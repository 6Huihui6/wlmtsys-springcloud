package com.hui.info.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.common.enums.AppHttpCodeEnum;
import com.hui.common.utils.BeanUtils;
import com.hui.common.utils.CollUtils;
import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Teams;
import com.hui.info.mapper.TeamsMapper;
import com.hui.info.service.ITeamsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.obs.service.OBSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TeamsServiceImpl extends ServiceImpl<TeamsMapper, Teams> implements ITeamsService {

    private final OBSService obsService;
    /**
     * 获取所有团队信息
     *
     * @return
     */
    @Override
    public List<Teams> getTeamsList(Integer depart) {
        List<Teams> teamsList = this.lambdaQuery()
                .orderByDesc(Teams::getCore)
                .eq(Teams::getDepart, depart).list();
        return teamsList;
    }

    /**
     * 保存团队信息
     *
     * @param Teams
     */
    @Override
    public void saveTeam(Teams Teams) {
        if (Teams.getDepart() != null&& Teams.getName() != null) {
            Teams.setCreateTime(LocalDateTime.now());
            this.save(Teams);
        }
    }

    /**
     * 删除团队信息
     *
     * @param id
     */
    @Override
    public void deleteTeam(Integer id) {
        if (id != null) {
            this.removeById(id);
        }
    }

    /**
     * 更新团队信息
     *
     * @param Teams
     */
    @Override
    public void updateTeam(Teams Teams) {
        Teams.setCreateTime(LocalDateTime.now());
        this.updateById(Teams);
    }

    /**
     * 分页查询团队信息
     *
     * @param query
     * @return
     */
    @Override
    public PageDTO<Teams> queryProjectPage(PageQuery query) {
        Page<Teams> page = this.lambdaQuery()
                .eq(query.getDepart()!=null,Teams::getDepart,query.getDepart())
                .like(query.getName()!=null,Teams::getName, query.getName())
                .like(query.getDesc()!=null,Teams::getDesc, query.getDesc())
                .page(query.toMpPage("core", false));
        List<Teams> records = page.getRecords();
        if (CollUtils.isEmpty(records)) {
            return PageDTO.empty(page);
        }
        List<Teams> TeamsList = new ArrayList<>();
        for (Teams news : records) {
            Teams Teams = BeanUtils.copyBean(news, Teams.class);
            TeamsList.add(Teams);
        }
        return PageDTO.of(page, TeamsList);
    }

    /**
     * 上传图片
     *
     * @param multipartFile
     */
    @Override
    public ResponseResult upload(MultipartFile multipartFile) {
        // 上传图片
        //1.检查参数
        if(multipartFile == null || multipartFile.getSize() == 0 ){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        String image = obsService.uploadImage(multipartFile, "team");
        return ResponseResult.okResult(image);

    }

    /**
     * 获取信息
     *
     * @param id
     * @return
     */
    @Override
    public Teams getTeamById(Integer id) {
        if (id != null) {
            return this.getById(id);
        }
        return null;
    }



}

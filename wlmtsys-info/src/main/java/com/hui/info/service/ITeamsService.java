package com.hui.info.service;

import com.hui.model.common.query.PageQuery;
import com.hui.model.info.dtos.PageDTO;
import com.hui.model.info.dtos.ResponseResult;
import com.hui.model.info.po.Teams;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hui
 * @since 2024-11-15
 */
public interface ITeamsService extends IService<Teams> {

    /**
     * 获取所有团队信息
     * @return
     */
    List<Teams> getTeamsList(Integer depart);

    /**
     * 保存团队信息
     * @param Teams
     */
    void saveTeam(Teams Teams);

    /**
     * 删除团队信息
     * @param id
     */
    void deleteTeam(Integer id);

    /**
     * 更新团队信息
     * @param Teams
     */
    void updateTeam(Teams Teams);

    /**
     * 分页查询团队信息
     * @param query
     * @return
     */
    PageDTO<Teams> queryProjectPage(PageQuery query);



    /**
     * 获取信息
     * @param id
     * @return
     */
    Teams getTeamById(Integer id);


    ResponseResult upload(MultipartFile multipartFile);
}

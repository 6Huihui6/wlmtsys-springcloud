package com.hui.post.service;

import com.hui.model.post.po.PointsBoard;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.model.post.query.PointsBoardQuery;
import com.hui.model.post.vo.PointsBoardVO;

/**
 * <p>
 * 积分榜单 服务类
 * </p>
 *
 * @author hui
 * @since 2024-12-11
 */
public interface IPointsBoardService extends IService<PointsBoard> {


    PointsBoardVO queryPointsBoardBySeason(PointsBoardQuery query);
}

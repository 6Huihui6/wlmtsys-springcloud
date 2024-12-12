package com.hui.post.service.impl;

import com.hui.common.utils.CollUtils;
import com.hui.common.utils.DateUtils;
import com.hui.model.post.po.PointsBoard;
import com.hui.model.post.po.Post;
import com.hui.model.post.query.PointsBoardQuery;
import com.hui.model.post.vo.PointsBoardItemVO;
import com.hui.model.post.vo.PointsBoardVO;
import com.hui.post.mapper.PointsBoardMapper;
import com.hui.post.service.IPointsBoardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.post.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.hui.post.constants.CommonConstants.POINTS_BOARD_KEY_PREFIX;

/**
 * <p>
 * 积分榜单 服务实现类
 * </p>
 *
 * @author hui
 * @since 2024-12-11
 */
@Service
@RequiredArgsConstructor
public class PointsBoardServiceImpl extends ServiceImpl<PointsBoardMapper, PointsBoard> implements IPointsBoardService {

    private final StringRedisTemplate redisTemplate;
    private final IPostService postService;
    @Override
    public PointsBoardVO queryPointsBoardBySeason(PointsBoardQuery query) {
        // 1.判断是否是查询当前赛季
        Long season = query.getSeason();
        boolean isCurrent = season == null || season == 0;
        // 2.获取Redis的Key
        LocalDateTime now = LocalDateTime.now();
        String key = POINTS_BOARD_KEY_PREFIX + now.format(DateUtils.POINTS_BOARD_SUFFIX_FORMATTER);
        // 2.查询我的积分和排名
//        PointsBoard myBoard = isCurrent ?
//                queryMyCurrentBoard(key) : // 查询当前榜单（Redis）
//                queryMyHistoryBoard(season); // 查询历史榜单（MySQL）
//        PointsBoard myBoard;
        List<PointsBoard> list;
        if (isCurrent) {
//            myBoard = queryMyCurrentBoard(key);
            list = queryCurrentBoardList(key, query.getPageNo(), query.getPageSize());
        } else {
            throw new RuntimeException("暂不支持查询历史榜单");
        }

        // 3.查询榜单列表
//        List<PointsBoard> list = isCurrent ?
//                queryCurrentBoardList(key, query.getPageNo(), query.getPageSize()) :
//                queryHistoryBoardList(query);
        // 4.封装VO
        PointsBoardVO vo = new PointsBoardVO();
        // 4.1.处理我的信息
//        vo.setPoints(myBoard.getPoints());
//        vo.setRank(myBoard.getRank());
        if (CollUtils.isEmpty(list)) {
            return vo;
        }
        // 4.2.查询用户信息
        Set<Integer> uIds = list.stream().map(PointsBoard::getPostId).collect(Collectors.toSet());
        List<Post> posts = postService.listByIds(uIds);
        Map<Integer, String> postMap = new HashMap<>(uIds.size());
        if (CollUtils.isNotEmpty(posts)) {
            postMap = posts.stream().collect(Collectors.toMap(Post::getPostId, Post::getTitle));
        }
        // 4.3.转换VO
        List<PointsBoardItemVO> items = new ArrayList<>(list.size());
        for (PointsBoard p : list) {
            PointsBoardItemVO v = new PointsBoardItemVO();
            v.setPoints(p.getPoints());
            v.setRank(p.getRank());
            v.setName(postMap.get(p.getPostId()));
            v.setPostId(p.getPostId());
            items.add(v);
        }
        vo.setBoardList(items);
        return vo;
    }
    public List<PointsBoard> queryCurrentBoardList(String key, Integer pageNo, Integer pageSize) {
        // 1.计算分页
        int from = (pageNo - 1) * pageSize;
        // 2.查询
        Set<ZSetOperations.TypedTuple<String>> tuples = redisTemplate.opsForZSet()
                .reverseRangeWithScores(key, from, from + pageSize - 1);
        if (CollUtils.isEmpty(tuples)) {
            return CollUtils.emptyList();
        }
        // 3.封装
        int rank = from + 1;
        List<PointsBoard> list = new ArrayList<>(tuples.size());
        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
            String postId = tuple.getValue();
            Double points = tuple.getScore();
            if (postId == null || points == null) {
                continue;
            }
            PointsBoard p = new PointsBoard();
            p.setPostId(Integer.valueOf(postId));
            p.setPoints(points.intValue());
            p.setRank(rank++);
            list.add(p);
        }
        return list;
    }
}

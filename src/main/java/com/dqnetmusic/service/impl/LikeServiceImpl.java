package com.dqnetmusic.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dqnetmusic.dao.LikeMapper;
import com.dqnetmusic.entity.Like;
import com.dqnetmusic.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dqnetmusic
 * @description: 收藏控制器
 * @author: BLADE
 * @create: 2021-02-14 17:36
 **/
@Service
public class LikeServiceImpl implements LikeService {

  @Autowired
  private LikeMapper likeMapper;

  @Override
  public boolean addLike(Like like) {
    return likeMapper.insert(like) > 0;
  }

  @Override
  public boolean deleteLike(Like like) {
    Map<String, Object> map = new HashMap<>();
    map.put("userid", like.getUserid());
    map.put("likeid", like.getLikeid());
    map.put("type", like.getType());
    return likeMapper.deleteByMap(map) > 0;
  }

  @Override
  public List<Like> showLikeByUserIdAndType(Long userid, Long type) {
    Map<String, Object> map = new HashMap<>();
    map.put("userid", userid);
    map.put("type", type);
    return likeMapper.selectByMap(map);
  }

  @Override
  public boolean isHaveLike(Like like) {
    QueryWrapper<Like> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("userid", like.getUserid());
    queryWrapper.eq("likeid", like.getLikeid());
    queryWrapper.eq("type", like.getType());

    return likeMapper.selectOne(queryWrapper) != null;
  }
}

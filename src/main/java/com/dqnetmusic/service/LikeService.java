package com.dqnetmusic.service;

import com.dqnetmusic.entity.Like;

import java.util.List;

public interface LikeService {

  boolean addLike(Like like);

  boolean deleteLike(Like like);

  List<Like> showLikeByUserIdAndType(Long userid,Long type);

  boolean isHaveLike(Like like);
}

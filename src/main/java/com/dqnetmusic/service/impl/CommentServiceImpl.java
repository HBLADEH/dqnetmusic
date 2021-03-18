package com.dqnetmusic.service.impl;

import com.dqnetmusic.dao.CommentMapper;
import com.dqnetmusic.entity.Comment;
import com.dqnetmusic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: dqnetmusic
 * @description: 评论服务类
 * @author: BLADE
 * @create: 2021-02-13 18:45
 **/
@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentMapper commentMapper;

  @Override
  public boolean addComment(Comment comment) {
    return commentMapper.insert(comment) > 0;
  }
}

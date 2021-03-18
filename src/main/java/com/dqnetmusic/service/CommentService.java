package com.dqnetmusic.service;

import com.dqnetmusic.entity.Comment;

public interface CommentService {
  /**
  * @Description: 添加一条评论
  * @Param: [comment]
  * @return:
  * @Author: BLADE
  * @Date: 2021/2/13
  */
  boolean addComment(Comment comment);
}

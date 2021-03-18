package com.dqnetmusic.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.dqnetmusic.entity.Comment;
import com.dqnetmusic.exception.AjaxResponse;
import com.dqnetmusic.exception.CustomExceptionType;
import com.dqnetmusic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: dqnetmusic
 * @description: 评论控制器
 * @author: BLADE
 * @create: 2021-02-13 18:44
 **/
@RestController
public class CommentController {

  @Autowired
  private CommentService commentService;

  @PostMapping("/comments")
  public AjaxResponse addComment(@RequestBody Comment comment) {
    try {
      comment.setUserid(StpUtil.getLoginIdAsLong());
    } catch (NotLoginException e) {
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "检测到用户没有登录!");
    }
    if (commentService.addComment(comment)) {
      return AjaxResponse.success();
    } else {
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "添加评论失败!");
    }
  }
}

package com.dqnetmusic.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.dqnetmusic.entity.Like;
import com.dqnetmusic.exception.AjaxResponse;
import com.dqnetmusic.exception.CustomExceptionType;
import com.dqnetmusic.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: dqnetmusic
 * @description: 收藏控制器
 * @author: BLADE
 * @create: 2021-02-14 17:35
 **/
@RestController
public class LikeController {

  @Autowired
  private LikeService likeService;

  @PostMapping("/likes")
  public AjaxResponse addLike(@RequestBody Like like) {
    try {
      like.setUserid(StpUtil.getLoginIdAsLong());
    } catch (NotLoginException e) {
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "检测到用户没有登录!");
    }

    if (likeService.isHaveLike(like)) {
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "已经收藏过了!");
    }

    if (likeService.addLike(like)) {
      return AjaxResponse.success();
    }
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "添加收藏失败!");
  }

  @DeleteMapping("/likes/{likeId}/{type}")
  public AjaxResponse deleteLike(@PathVariable Long likeId, @PathVariable Long type) {
    Like like = new Like(likeId, type);
    try {
      like.setUserid(StpUtil.getLoginIdAsLong());
    } catch (NotLoginException e) {
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "检测到用户没有登录!");
    }

    if (likeService.deleteLike(like)) {
      return AjaxResponse.success();
    }
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "删除收藏失败!");
  }

  @GetMapping("/likes/{type}")
  public AjaxResponse selectLikesByUserIdAndType(@PathVariable Long type) {
    long userId;
    try {
      userId = StpUtil.getLoginIdAsLong();
    } catch (NotLoginException e) {
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "检测到用户没有登录!");
    }
    List<Like> likeList = likeService.showLikeByUserIdAndType(userId, type);
    if (likeList != null)
      return AjaxResponse.success(likeList);
    return AjaxResponse.success(null, "没有查询到信息");
  }
}

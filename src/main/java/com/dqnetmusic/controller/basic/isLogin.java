package com.dqnetmusic.controller.basic;

import cn.dev33.satoken.stp.StpUtil;
import com.dqnetmusic.exception.AjaxResponse;
import com.dqnetmusic.exception.CustomExceptionType;

/**
 * @program: dqnetmusic
 * @description: 是否登录检测
 * @author: BLADE
 * @create: 2021-02-11 22:13
 **/
public class isLogin {
  public isLogin() {
    checkLogin();
  }

  public void checkLogin() {
    if (!StpUtil.isLogin()) {
      AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "用户未登录");
    }
  }
}

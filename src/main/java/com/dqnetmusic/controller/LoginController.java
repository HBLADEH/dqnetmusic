package com.dqnetmusic.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.dqnetmusic.dao.UserMapper;
import com.dqnetmusic.entity.User;
import com.dqnetmusic.exception.AjaxResponse;
import com.dqnetmusic.exception.CustomExceptionType;
import com.dqnetmusic.service.LoginService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: dqnetmusic
 * @description: 登录注册控制器
 * @author: BLADE
 * @create: 2021-02-08 20:32
 **/
@RestController
public class LoginController {
  @Autowired
  LoginService loginService;


  @PostMapping("/login")
  public AjaxResponse login(@RequestParam String name, @RequestParam String password) {
    User user = loginService.checkLogin(name, password);
    if (user != null) {
      StpUtil.setLoginId(user.getId());
      return AjaxResponse.success();
    } else {
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "用户名密码错误");
    }
  }

  @PostMapping("/doLogout")
  public AjaxResponse logout() {
    StpUtil.logout();
    return AjaxResponse.success();
  }


  @PostMapping("/register")
  public AjaxResponse register(@RequestBody User user) {
    if (loginService.checkUsername(user.getName()))
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "用户名已存在!");

    if (loginService.doRegister(user)) {
      return AjaxResponse.success();
    }

    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "用户注册失败!");

  }
}

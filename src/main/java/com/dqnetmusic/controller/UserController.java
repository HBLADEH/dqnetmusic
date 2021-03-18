package com.dqnetmusic.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.dqnetmusic.dao.UserMapper;
import com.dqnetmusic.entity.User;
import com.dqnetmusic.exception.AjaxResponse;
import com.dqnetmusic.exception.CustomExceptionType;
import com.dqnetmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: dqnetmusic
 * @description: 用户控制器
 * @author: BLADE
 * @create: 2021-02-08 16:05
 **/
@RestController
public class UserController {


  @Autowired
  UserMapper userMapper;

  @GetMapping("/users")
  public AjaxResponse listUsers() {
    StpUtil.checkLogin();
      List<User> userList = userMapper.selectList(null);
      return AjaxResponse.success(userList,"获取用户信息成功");
  }
  @GetMapping("/users/{userId}")
  public AjaxResponse findUserById (@PathVariable Long userId) {
    User user = userMapper.selectById(userId);
    return AjaxResponse.success(user, "获取用户信息成功");
  }
}

package com.dqnetmusic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dqnetmusic.dao.UserMapper;
import com.dqnetmusic.entity.User;
import com.dqnetmusic.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @program: dqnetmusic
 * @description: 登录服务层
 * @author: BLADE
 * @create: 2021-02-09 12:38
 **/
@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  BCryptPasswordEncoder encoder;

  public User checkLogin(String name, String password) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
    queryWrapper.eq("name", name);
    User user = userMapper.selectOne(queryWrapper);
    boolean result = encoder.matches(password, user.getPassword());
    if (result) {
      return user;
    } else {
      return null;
    }
  }

  @Override
  public boolean doRegister(User user) {
    return userMapper.insert(user) > 0;
  }

  @Override
  public boolean checkUsername(String name) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("name", name);
    User user = userMapper.selectOne(queryWrapper);
    return  user != null;
  }
}

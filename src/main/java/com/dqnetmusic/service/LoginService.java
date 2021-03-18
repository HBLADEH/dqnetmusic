package com.dqnetmusic.service;


import com.dqnetmusic.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

  /**
  * @Description: 登录检测
  * @Param: [name, password]
  * @return: 是否登录
  * @Author: BLADE
  * @Date: 2021/2/9
  */
  User checkLogin(String name, String password);


  boolean doRegister(User user);


  boolean checkUsername(String name);

}

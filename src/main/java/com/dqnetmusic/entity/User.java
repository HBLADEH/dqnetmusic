package com.dqnetmusic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: dqnetmusic
 * @description: 用户表
 * @author: BLADE
 * @create: 2021-02-08 16:01
 **/
@Data
public class User {
  @TableId(value = "id",type = IdType.INPUT)
  private Long id;
  private String name;
  private String password;
}

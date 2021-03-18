package com.dqnetmusic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @program: dqnetmusic
 * @description: 评论实体类
 * @author: BLADE
 * @create: 2021-02-13 18:42
 **/
@Data
public class Comment {
  @TableId(value = "id",type = IdType.INPUT)
  private Long id;
  private Long userid;
  private String comment;
  private Long typeid;
  private int type;
  private Date createdate;
}

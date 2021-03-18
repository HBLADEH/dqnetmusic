package com.dqnetmusic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * @program: dqnetmusic
 * @description: 收藏表
 * @author: BLADE
 * @create: 2021-02-14 17:34
 **/
@Data
public class Like {
  public Like() {
  }

  public Like(Long likeid, Long type) {
    this.likeid = likeid;
    this.type = type;
  }

  private Long userid;
  private Long likeid;
  private Long type;
}

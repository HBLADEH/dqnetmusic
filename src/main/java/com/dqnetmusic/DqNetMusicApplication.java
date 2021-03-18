package com.dqnetmusic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@MapperScan("com.dqnetmusic.dao")
public class DqNetMusicApplication {

  public static void main(String[] args) {
    SpringApplication.run(DqNetMusicApplication.class, args);
  }

}

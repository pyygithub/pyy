package com.thtf.generator.config;

import com.ibeetl.starter.BeetlTemplateCustomize;
import org.beetl.core.GroupTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ========================
 * MyBeetl配置
 * Author：pyy
 * Date：2019-9-25 16:45:06
 * Version: v1.0
 * ========================
 */
@Configuration
public class MyBeetlConfig {
	
  @Bean
  public BeetlTemplateCustomize beetlTemplateCustomize(){
    return new BeetlTemplateCustomize(){
      public void customize(GroupTemplate groupTemplate){

      }
    };
  }
}
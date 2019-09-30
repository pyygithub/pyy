package com.thtf.generator.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * ========================
 * Mybatis配置
 * Author：pyy
 * Date：2019-9-25 16:45:06
 * Version: v1.0
 * ========================
 */
@Configuration
@MapperScan("com.thtf.generator.**.dao")// 扫描DAO
public class MybatisConfig {
  @Autowired
  private DataSource dataSource;

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setTypeAliasesPackage("com.thtf.generator.**.model");	// 扫描Model
    
	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/mappers/*.xml"));	// 扫描映射文件
	
    return sessionFactory.getObject();
  }
}
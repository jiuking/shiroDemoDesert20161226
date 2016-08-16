package com.hjc.demo.util;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

public class JdbcTemplateUtils {
	
	private static volatile JdbcTemplate jdbcTemplate;
	
	public static JdbcTemplate getJdbcTemplate(){
		
		if(jdbcTemplate == null){
			synchronized (JdbcTemplate.class) {
				if(jdbcTemplate == null){
					jdbcTemplate = createJdbcTemplate();
				}
			}
		}
		return jdbcTemplate;
	}

	private static JdbcTemplate createJdbcTemplate() {
		// TODO Auto-generated method stub
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/shiro");
		ds.setUsername("root");
		ds.setPassword("123456");
		return new JdbcTemplate(ds);
	}
}

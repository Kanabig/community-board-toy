package com.office.board.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcTemplateConfig {

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();

		// connection
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/db_community");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("1234");
		
		// connection pool
		basicDataSource.setInitialSize(5);
		basicDataSource.setMaxTotal(10);
		basicDataSource.setMaxIdle(2);
		basicDataSource.setMinIdle(2);
		
		return basicDataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;
	}
	
}

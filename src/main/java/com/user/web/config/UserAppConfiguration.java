package com.user.web.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.user.web.daoimpl.UserDaoImpl;

@EnableWebMvc
@ComponentScan(basePackages = "com.user.web.*")
@Configuration
public class UserAppConfiguration {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		// set location of views.
		vr.setPrefix("/WEB-INF/views/");

		// set the extension of views.
		vr.setSuffix(".jsp");

		return vr;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/userdb?searchpath=user_schema");// change url
		dataSource.setUsername("postgres");// change userid
		dataSource.setPassword("Naidu@123");// change pwd

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	/*
	 * @Bean public UserDaoImpl userDaoImpl(){ UserDaoImpl userDaoImpl = new
	 * UserDaoImpl(); userDaoImpl.setJdbcTemplate(jdbcTemplate()); return
	 * userDaoImpl; }
	 */

}

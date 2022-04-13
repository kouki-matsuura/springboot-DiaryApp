package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DiaryAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DiaryAppApplication.class, args);
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String...strings ) throws Exception {
		jdbcTemplate.execute("CREATE TABLE if not exists m_diary(" +
				"id INT PRIMARY KEY, title VARCHAR(50), day DATE, face VARCHAR, text VARCHAR)");
		jdbcTemplate.execute("CREATE TABLE if not exists m_user(" +
				"name VARCHAR(50) PRIMARY KEY, photo VARCHAR, birthday DATE, age INT, gender INT, content VARCHAR)");
	}
	

}

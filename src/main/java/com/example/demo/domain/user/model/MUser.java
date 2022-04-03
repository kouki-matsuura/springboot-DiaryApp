package com.example.demo.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MUser {
	private String name;
	private String photo;
	private Date birthday;
	private Integer age;
	private Integer gender;
	private String content;
}
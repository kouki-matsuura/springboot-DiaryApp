package com.example.demo.form;

import java.util.Date;

import lombok.Data;

@Data
public class UserProfileForm {
	private String name;
	private Date birthday;
	private Integer age;
	private Integer gender;
}
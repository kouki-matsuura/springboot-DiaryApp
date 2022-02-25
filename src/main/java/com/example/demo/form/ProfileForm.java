package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProfileForm {
	@NotBlank(groups=ValidGroup1.class)
	private String name;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(groups=ValidGroup1.class)
	private Date birthday;
	
	@Min(value=18, groups=ValidGroup2.class)
	@Max(value=100, groups=ValidGroup2.class)
	private Integer age;
	
	@NotNull(groups=ValidGroup1.class)
	private Integer gender;
}
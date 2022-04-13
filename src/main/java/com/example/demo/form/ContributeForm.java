package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ContributeForm {
	private Integer id;
	
	@NotBlank(groups=ValidGroup1.class)
	private String title;
	
	@NotNull(groups=ValidGroup1.class)
	private String face;
	
	@NotNull(groups=ValidGroup1.class)
	private String text;
}
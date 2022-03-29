package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ContributeForm {
	@NotBlank(groups=ValidGroup1.class)
	private String title;
	
	@NotNull(groups=ValidGroup1.class)
	private Integer face;
	
	@NotNull(groups=ValidGroup1.class)
	private String text;
}
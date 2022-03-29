package com.example.demo.domain.user.model;


import java.util.Date;

import lombok.Data;

@Data
public class MText {
	private Date day;
	private String title;
	private Integer face;
	private String text;
}
package com.example.demo.domain.user.model;


import java.util.Date;

import lombok.Data;

@Data
public class MText {
	private Integer id;
	private Date day;
	private String title;
	private String face;
	private String text;
}
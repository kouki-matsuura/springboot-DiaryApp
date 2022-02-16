package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class DiaryAppController {
	@GetMapping("/head")
	public String getHead() {
		//head.htmlに画面遷移
		return "main/head";
	}
}
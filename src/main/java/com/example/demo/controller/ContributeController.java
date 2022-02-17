package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contribute")
public class ContributeController {
	@GetMapping("/contribute")
	public String getContribute() {
		//head.htmlに画面遷移
		return "contribute/contribute";
	}
}
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/digest")
public class DigestController {
	@GetMapping("/digest")
	public String getDigest() {
		//head.htmlに画面遷移
		return "digest/digest";
	}
}
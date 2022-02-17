package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserApplicationService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@GetMapping("/profile")
	public String getProfile() {
		//profile.htmlに画面遷移
		return "profile/profile";
	}
	
	@GetMapping("/edit")
	public String getEdit(Model model) {
		//性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		
		return "profile/edit";
	}
}
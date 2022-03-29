package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.UserService;
import com.example.demo.domain.user.model.MText;
import com.example.demo.form.ContributeForm;

@Controller
@RequestMapping("/main")
public class DiaryAppController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/top")
	public String getTop(ContributeForm form, Model model) {
		
		List<MText> diaries = userService.getDiaries();
		model.addAttribute("diaries", diaries);
		System.out.println(diaries);
		//head.htmlに画面遷移
		return "main/Top";
	}
}
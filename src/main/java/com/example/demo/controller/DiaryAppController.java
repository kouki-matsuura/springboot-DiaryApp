package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.UserService;
import com.example.demo.domain.user.model.MText;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.form.ContributeForm;
import com.example.demo.form.ProfileForm;

@Controller
@RequestMapping("/main")
public class DiaryAppController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageController imageController;
	
	
	@GetMapping("/top")
	public String getTop(ContributeForm form, ProfileForm profileForm, Model model) throws IOException {
		List<MText> diaries = userService.getDiaries();
		MUser user = userService.getProfile();
		String defaultImage = imageController.getImage("User");
		System.out.print(user);
		model.addAttribute("profileForm", user);
		model.addAttribute("diaries", diaries);	
		model.addAttribute("defaultImage", defaultImage);
		return "main/Top";
	}

}
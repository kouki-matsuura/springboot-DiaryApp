package com.example.demo.controller;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.UserService;
import com.example.demo.application.service.UserApplicationService;
import com.example.demo.domain.user.model.MText;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.form.ContributeForm;
import com.example.demo.form.GroupOrder;

@Controller
@RequestMapping("/contribute")
public class ContributeController {
	@Autowired
	private UserApplicationService userApplicationService;
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ImageController imageController;
	
	@GetMapping("/contribute")
	public String getContribute(@ModelAttribute ContributeForm form, Model model) throws IOException {
		//faceMapを取得
		String[] condition = userApplicationService.getFaceMap();
		MUser user = userService.getProfile();
		String defaultImage = imageController.getImage("User");
		model.addAttribute("condition", condition);
		model.addAttribute("profileForm", user);
		model.addAttribute("defaultImage", defaultImage);
		return "contribute/contribute";
	}
	
	@PostMapping("/contribute")
	public String postContribute(Model model, @ModelAttribute @Validated(GroupOrder.class) ContributeForm form, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) {
			return getContribute(form, model);
		}
		//formをMTextクラスに変換 
		MText diary = modelMapper.map(form, MText.class);
		System.out.print(diary);
		userService.setDiary(diary);
		return "redirect:/main/top";
		//MText diary = modelMapper.map(form, MText.class);
	}
}
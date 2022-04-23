package com.example.demo.controller;

import java.util.Map;

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
import com.example.demo.domain.user.model.MUser;
import com.example.demo.form.GroupOrder;
import com.example.demo.form.ProfileForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/profile")
@Slf4j
public class EditProfileController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/edit")
	public String getEdit(Model model, @ModelAttribute ProfileForm form) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		
		return "profile/edit";
	}
	
	@GetMapping("/new")
	public String getNew(Model model, @ModelAttribute ProfileForm form) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		
		return "profile/new";
	}
	
	@PostMapping("/edit")
	public String postEdit(Model model, @ModelAttribute @Validated(GroupOrder.class) ProfileForm form, BindingResult bindingResult) {
		//入力チェック
		if (bindingResult.hasErrors()) {
			//プロフィール編集画面に戻る
			return getEdit(model, form);
		}
		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		//ユーザー登録
		System.out.print("user:"+user);
		userService.updateProfile(user);
		//プロフィール画面にリダイレクト
		return "redirect:/main/top";
	}
	
	@PostMapping("/new")
	public String postNew(Model model, @ModelAttribute @Validated(GroupOrder.class) ProfileForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return getNew(model, form);
		}
		MUser user = modelMapper.map(form, MUser.class);
		userService.setProfile(user);
		//トップ画面にリダイレクト
		return "redirect:/main/top";
	}
}
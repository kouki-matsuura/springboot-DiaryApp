package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.UserService;
import com.example.demo.domain.user.model.MText;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.form.ContributeForm;
import com.example.demo.form.ProfileForm;

@Controller
@RequestMapping("main")
public class DiaryAppController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageController imageController;
	
	@GetMapping("/top")
	public String getTop(ContributeForm form, ProfileForm profileForm, Model model) throws IOException {
		List<MText> diaries = userService.getDiaries();
		String dateToStr = DateFormatUtils.format(diaries.get(0).getDay(), "M");
		System.out.println("M: "+dateToStr);
		MUser user = userService.getProfile();
		String defaultImage = imageController.getImage("User");
		model.addAttribute("profileForm", user);
		model.addAttribute("diaries", diaries);	
		model.addAttribute("defaultImage", defaultImage);
		return "main/top";
	}
	
	@PostMapping(value="/top", params="prev")
	public String prevMonth() {
		return "redirect:./top";
	}
	
	@PostMapping(value="/top", params="delete")
	public String deleteDiary(@RequestParam Integer ID) {
		System.out.println("削除ボタン " +ID);
		userService.deleteDiary(ID);
		return "redirect:./top";
	}
	
	@PostMapping(value="/top", params="edit")
	public String editDiary(@RequestParam String ID, RedirectAttributes redirectAttrs) {
		System.out.println("編集ボタン " + ID);
		redirectAttrs.addAttribute("id", ID);
		return "redirect:/contribute/edit";
	}

}
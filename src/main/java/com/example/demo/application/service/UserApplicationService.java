package com.example.demo.application.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ImageController;

@Service
public class UserApplicationService {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ImageController imageController;
	
	//性別のMapを生成
	public Map<String, Integer> getGenderMap() {
		Map<String, Integer> genderMap = new LinkedHashMap <>();
		String male = messageSource.getMessage("male", null, Locale.JAPANESE);
		String female = messageSource.getMessage("female", null, Locale.JAPANESE);
		genderMap.put(male, 1);
		genderMap.put(female, 2);
		genderMap.put("未登録", 3);
		return genderMap;
	}
	
	//顔のMapを生成
	public String[] getFaceMap() throws IOException {
		String[] condition = new String[5];
		condition[0] = imageController.getImage("verySad");
		condition[1] = imageController.getImage("sad");
		condition[2] = imageController.getImage("normal");
		condition[3] = imageController.getImage("happy");
		condition[4] = imageController.getImage("veryHappy");
		return condition;
	}
}
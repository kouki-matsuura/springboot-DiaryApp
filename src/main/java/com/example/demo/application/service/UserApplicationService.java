package com.example.demo.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
	
	@Autowired
	private MessageSource messageSource;
	
	//性別のMapを生成
	public Map<String, Integer> getGenderMap() {
		Map<String, Integer> genderMap = new LinkedHashMap <>();
		String male = messageSource.getMessage("male", null, Locale.JAPANESE);
		String female = messageSource.getMessage("female", null, Locale.JAPANESE);
		genderMap.put(male, 1);
		genderMap.put(female, 2);
		return genderMap;
	}
	
	//顔のMapを生成
	public Map<String, Integer> getFaceMap() {
		Map<String, Integer> faceMap = new LinkedHashMap <>();
		String soGood = messageSource.getMessage("sogood", null, Locale.JAPANESE);
		String good = messageSource.getMessage("good", null, Locale.JAPANESE);
		String normal = messageSource.getMessage("normal", null, Locale.JAPANESE);
		String bad = messageSource.getMessage("bad", null, Locale.JAPANESE);
		String soBad = messageSource.getMessage("sobad", null, Locale.JAPANESE);
		faceMap.put(soGood, 5);
		faceMap.put(good, 4);
		faceMap.put(normal, 3);
		faceMap.put(bad, 2);
		faceMap.put(soBad, 1);
		return faceMap;
	}
}
package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
	@Autowired
	ResourceLoader resourceLoader;
	
	@ResponseBody
	@RequestMapping(value = "/getImage/{id}", method = {RequestMethod.GET})
	public String getImage(@PathVariable String id) throws IOException {
		//リソースファイルの読み込み
		Resource resource = resourceLoader.getResource("classpath:" + "/static/images/" + id + ".png");
		InputStream image = resource.getInputStream();
		
		//byteに変換
		byte[] b = IOUtils.toByteArray(image);
		String base64Data = Base64.getEncoder().encodeToString(b);
		return "data:image/png;base64,"+ base64Data;
	}
}
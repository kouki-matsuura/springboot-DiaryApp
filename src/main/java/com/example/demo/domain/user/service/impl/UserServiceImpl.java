package com.example.demo.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserService;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;
	
	//ユーザ登録
	@Override
	public void updateProfile(MUser user) {
		mapper.updateOne(user);
	}
	
	//ユーザ取得
	@Override
	public MUser getProfile() {
		return mapper.findOne();
	}
}
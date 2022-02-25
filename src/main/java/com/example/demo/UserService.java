package com.example.demo;

import com.example.demo.domain.user.model.MUser;

public interface UserService {
	//プロフィール更新
	public void updateProfile(MUser user);
	//プロフィール取得
	public MUser getProfile();
	
}

package com.example.demo;

import java.util.Date;
import java.util.List;

import com.example.demo.domain.user.model.MText;
import com.example.demo.domain.user.model.MUser;

public interface UserService {
	//プロフィール更新
	public void updateProfile(MUser user);
	//プロフィール取得
	public MUser getProfile();
	//投稿内容全件取得
	public List<MText> getDiaries();
	//投稿内容取得
	public MText getDiary(Date day);
	//投稿内容登録
	public void setDiary(MText diary);
}

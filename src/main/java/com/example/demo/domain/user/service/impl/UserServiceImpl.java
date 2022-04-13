package com.example.demo.domain.user.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserService;
import com.example.demo.domain.user.model.MText;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.repository.DiaryMapper;
import com.example.demo.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper user_mapper;
	
	@Autowired
	private DiaryMapper diary_mapper;
	
	//プロフィール更新
	@Override
	public void updateProfile(MUser user) {
		user_mapper.updateOne(user);
	}
	
	//プロフィール取得
	@Override
	public MUser getProfile() {
		return user_mapper.findOne();
	}
	
	//投稿内容全件取得
	@Override
	public List<MText> getDiaries() {
		return diary_mapper.findMany();
	}
	
	//投稿内容を日付で取得
	@Override
	public List<MText> getDiary(Date day) {
		return diary_mapper.findOne(day);
	}
	
	//投稿内容をIDで取得
	@Override
	public MText getDiaryByID(Integer id) {
		return diary_mapper.findOneByID(id);
	}
	//投稿内容登録
	@Override
	public void  setDiary(MText diary) {
		diary.setDay(new Date());
		Random random = new Random();
		List<MText> diaries = getDiaries();
		int diaryID = diaries.size();
		
		if (diaries.size() > 0) {
			for (MText content:diaries) {
				System.out.println("これまでの日記のIDは"+content.getId());
				if (diaryID != content.getId()) {
					 System.out.println("今回の日記のIDは"+diaryID);
					break;
				}
				diaryID--; 
			}
		}
		diary.setId(diaryID);
		System.out.println(diary);
		diary_mapper.insertOne(diary);
	}
	
	//投稿内容削除
	@Override
	public void deleteDiary(Integer id) {
		diary_mapper.deleteOne(id);
	}
	//投稿内容更新
	@Override
	public void updateDiary(MText diary) {
		diary_mapper.updateOne(diary);
	}
}
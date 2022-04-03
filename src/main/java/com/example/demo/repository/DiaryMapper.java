package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.user.model.MText;

@Mapper
public interface DiaryMapper {
	//投稿内容1件取得
	public List<MText> findOne(Date day);
	//投稿内容全件取得
	public List<MText> findMany();
	//投稿内容登録
	public void insertOne(MText diary);
}

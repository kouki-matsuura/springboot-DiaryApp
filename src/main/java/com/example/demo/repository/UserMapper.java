package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.user.model.MUser;

@Mapper
public interface UserMapper {
	//プロフィール取得
	public MUser findOne();
	//プロフィール更新
	public void updateOne(@Param("user") MUser user);
	//プロフィール登録
	public void insertOne(@Param("user") MUser user);
}

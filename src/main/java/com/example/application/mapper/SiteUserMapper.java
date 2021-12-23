package com.example.application.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.application.entity.SiteUser;

@Mapper
public interface SiteUserMapper {

	// ユーザー名をもとにユーザーデータを取得
	public SiteUser getLoginUser(String name);
}

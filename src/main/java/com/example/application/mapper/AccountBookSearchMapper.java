package com.example.application.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.application.entity.AccountBook;

@Mapper
public interface AccountBookSearchMapper {

	// 初期表示
	public List<AccountBook> getThisMonth(int user_id, int year, int month);
}

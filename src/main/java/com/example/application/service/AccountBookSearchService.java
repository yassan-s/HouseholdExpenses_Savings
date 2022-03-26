package com.example.application.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.entity.AccountBook;
import com.example.application.mapper.AccountBookSearchMapper;

@Service
public class AccountBookSearchService {

	@Autowired
	private AccountBookSearchMapper SearchMapper;

	/**
	* 初期分析画面表示
	* @param user_id
	* @param thisMonth
	* @return List<AccountBook>
	*/
	public List<AccountBook> getAccountBookList(int user_id, int thisMonth){
		// 途中 Mapper側でメソッドを未実装
		return SearchMapper.getThisMonth(user_id, thisMonth);
	}


	/**
	* 現在日時を習得する
	* @param
	* @return nowTimeStr
	*/
	public String getLocalDateTimeNow() {
			LocalDateTime nowTime = LocalDateTime.now();
			String nowTimeStr = nowTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		return nowTimeStr;
	}

}

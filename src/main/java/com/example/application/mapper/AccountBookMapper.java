package com.example.application.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.application.entity.AccountBook;

@Mapper
public interface AccountBookMapper {

	// 全件取得
	public List<AccountBook> selectAll(int user_id);

	// 1件登録
	public void insertAccountBook(AccountBook accountBook);

	// 1件取得
	public AccountBook getAccountBook(int id);

	// 1件更新
	public void updateAccountBook(AccountBook accountBook);

	// 1件削除
	public void deleteAccountBook(int id);

}

package com.example.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.entity.AccountBook;
import com.example.application.entity.Category;
import com.example.application.mapper.AccountBookMapper;
import com.example.application.mapper.CategoryMapper;

@Service
public class AccountBookService {

	@Autowired
	AccountBookMapper accountBookMapper;

	@Autowired
	CategoryMapper categoryMapper;

	/**
	* 一覧表示
	* @return List<AccountBook>
	*/
	public List<AccountBook> getAccountBookList(int user_id){
		return accountBookMapper.selectAll(user_id);
	}

	/**
	* 入出金データ１件の登録
	* @param accountBook
	*/
	public void insert(AccountBook accountBook) {
		accountBookMapper.insertAccountBook(accountBook);
	}

	/**
	* 1件のレコードを取得し,Form画面表示(更新処理用)
	* @param id
	*/
	public AccountBook getAccountBook(int id) {
		return accountBookMapper.getAccountBook(id);
	}

	/**
	* 入出金データ１件の更新
	* @param accountBook
	*/
	public void updateAccountBook(AccountBook accountBook) {
		accountBookMapper.updateAccountBook(accountBook);
	}

	/**
	* 入出金データ１件の削除
	* @param id
	*/
	public void deleteAccountBook(int id) {
		accountBookMapper.deleteAccountBook(id);
	}

	/**
	* 全カテゴリーの取得
	* @param
	* @return List<Category>
	*/
	public List<Category> getCategoryAll(){
		return categoryMapper.getCategoryAll();
	}


	/**
	* 収入の集計
	* 計算の条件 income_cost_flg == １
	* @param List<AccountBook> accountBooks
	* @return totalIncome
	*/
	public int sumIncome(List<AccountBook> accountBooks) {

		int totalIncome = 0;

		for (AccountBook accountBook : accountBooks) {
			if (accountBook.getIncome_cost_flg() == 1) {
			totalIncome += accountBook.getMoney();
			}
		}
		return totalIncome;
	}

	/**
	* 支出の集計
	* 計算の条件 income_cost_flg == 0
	* @param List<AccountBook> accountBooks
	* @return totalIncome
	*/
	public int sumCost(List<AccountBook> accountBooks) {

		int totalCost = 0;

		for (AccountBook accountBook : accountBooks) {
			if (accountBook.getIncome_cost_flg() == 0) {
				totalCost += accountBook.getMoney();
			}
		}
		return totalCost;
	}

}

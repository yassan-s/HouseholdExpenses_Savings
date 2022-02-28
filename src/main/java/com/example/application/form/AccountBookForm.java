package com.example.application.form;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.application.entity.Category;

/**
* Formの入力値を格納
*/
public class AccountBookForm {

	private int id;

	private int user_id;

	// form画面から取得した値をformat変換する
	// 入力値はString型として扱われるため
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate recode_date;

	private int category_id;

	private int money;

	private int income_cost_flg;

	private String note;

	// カテゴリー全件を格納
	private List<Category> categories;

	// form画面判別用
	// true  新規登録
	// false 更新処理
	private boolean newAccountBook;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public LocalDate getRecode_date() {
		return recode_date;
	}
	public void setRecode_date(LocalDate recode_date) {
		this.recode_date = recode_date;
	}

	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public int getIncome_cost_flg() {
		return income_cost_flg;
	}
	public void setIncome_cost_flg(int income_cost_flg) {
		this.income_cost_flg = income_cost_flg;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public boolean isNewAccountBook() {
		return newAccountBook;
	}
	public void setNewAccountBook(boolean newAccountBook) {
		this.newAccountBook = newAccountBook;
	}

	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


}

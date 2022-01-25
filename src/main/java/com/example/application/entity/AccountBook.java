package com.example.application.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
* 貯金(Saving)項目と金額
*/
public class AccountBook {

	private int id;
	private int user_id;
	private LocalDate recode_date;
	private int category_id;
	private Category category;
	private int money;
	private int income_cost_flg;
	private String note;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;


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

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
}

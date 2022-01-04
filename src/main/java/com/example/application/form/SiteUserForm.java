package com.example.application.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SiteUserForm {

	@NotBlank(message = "必須項目です")
	@Size(min = 3, max = 30, message = "3文字以上30文字以内で記入してください")
	private String name;

	@NotBlank(message = "必須項目です")
	@Size(min = 4, max = 10, message = "4文字以上10文字以内で記入してください")
	private String password;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

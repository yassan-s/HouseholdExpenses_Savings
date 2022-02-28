package com.example.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* 家計簿の記録内容を分析する
*
*/
@Controller
@RequestMapping("/search")
public class AccountBookSearchController {

	/**
	* 分析のTop画面表示
	* @param model
	* @return html accountBookSearch/SearchTop
	*/
	@GetMapping
	public String getSearchTop() {
		return "accountBookSearch/SearchTop";
	}

	/**
	* 年ごとの収支を表示
	* @param model
	* @return html accountBookSearch/SearchTop
	*/
	@GetMapping("/year")
	public String getSearchYear() {
		return "accountBookSearch/SearchTop";
	}


}

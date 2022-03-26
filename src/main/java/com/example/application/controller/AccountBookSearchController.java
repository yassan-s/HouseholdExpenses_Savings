package com.example.application.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.AccountBookSearchService;

/**
* 家計簿の記録内容を分析する
*
*/
@Controller
@RequestMapping("/search")
public class AccountBookSearchController {

	@Autowired
	private AccountBookSearchService service;

	/**
	* 分析のTop画面表示
	* @param model
	* @return html accountBookSearch/SearchTop
	*/
	@GetMapping
	public String getSearchTop(Model model) {

		String nowTime = service.getLocalDateTimeNow();

		model.addAttribute("nowTime", nowTime);

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

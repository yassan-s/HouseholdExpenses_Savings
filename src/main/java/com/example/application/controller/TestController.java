package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.AccountBookService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	AccountBookService service;

	@GetMapping
	public String accessTest(Model model) {

		model.addAttribute("test", "test success!");


		return "test";
	}

}

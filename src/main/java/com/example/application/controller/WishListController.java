package com.example.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wishList")
public class WishListController {

	@GetMapping
	public String getList() {
		return "wishList/wishList";
	}

}

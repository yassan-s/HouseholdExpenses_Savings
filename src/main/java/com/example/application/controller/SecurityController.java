package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.application.entity.SiteUser;
import com.example.application.form.SiteUserForm;
import com.example.application.service.UserDetailsServiceImpl;

@Controller
public class SecurityController {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	public String register(@ModelAttribute SiteUserForm siteUserForm) {

		userDetailsService.register(changeSiteUser(siteUserForm));

		return "redeirct:/longin";
	}

	public SiteUser changeSiteUser(SiteUserForm siteUserForm) {

		SiteUser siteUser = new SiteUser();
		siteUser.setName(siteUserForm.getName());
		siteUser.setPassword(siteUserForm.getPassword());
		return siteUser;
	}

}

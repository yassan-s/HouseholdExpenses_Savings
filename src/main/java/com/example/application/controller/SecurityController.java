package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.application.entity.SiteUser;
import com.example.application.form.SiteUserForm;
import com.example.application.service.UserDetailsServiceImpl;

/**
* ログイン画面やユーザー登録を制御する
*
*/
@Controller
public class SecurityController {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	/**
	* ログイン画面
	* @param
	* @return login
	*/
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/**
	* ユーザー登録画面
	* @param SiteUserForm siteUserForm
	* @return signup
	*/
	@GetMapping("/signup")
	public String signup(@ModelAttribute SiteUserForm siteUserForm) {
		return "signup";
	}

	/**
	* ユーザー登録
	* @param SiteUserForm siteUserForm
	* @return redirect:/login
	*/
	@PostMapping("/signup")
	public String register(@ModelAttribute SiteUserForm siteUserForm) {

		userDetailsService.register(changeSiteUser(siteUserForm));

		return "redirect:/login";
	}

	/**
	* SiteUserForm(Form)からSiteUser(entity)に変換
	* @param SiteUserForm siteUserForm
	* @return siteUser
	*/
	public SiteUser changeSiteUser(SiteUserForm siteUserForm) {

		SiteUser siteUser = new SiteUser();
		siteUser.setName(siteUserForm.getName());
		siteUser.setPassword(siteUserForm.getPassword());
		return siteUser;
	}

}

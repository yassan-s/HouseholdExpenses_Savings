package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String register(@ModelAttribute @Validated SiteUserForm siteUserForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		//バリデーションに問題がある場合
		if (bindingResult.hasErrors()) {
			return "signup";
		}
		//登録処理を実行
		//問題なければtrue 同一名があればfalse
		boolean checkRegister = userDetailsService.register(changeSiteUser(siteUserForm));

		if (checkRegister) {
			redirectAttributes.addFlashAttribute("registerOK", "新規登録が完了しました ログインしてください");
			return "redirect:/login";
		} else {
			redirectAttributes.addFlashAttribute(siteUserForm);
			return "redirect:/signup?error";
		}

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

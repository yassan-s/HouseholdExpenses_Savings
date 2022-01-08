package com.example.application.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.application.entity.AccountBook;
import com.example.application.entity.Category;
import com.example.application.entity.SiteUser;
import com.example.application.form.AccountBookForm;
import com.example.application.mapper.SiteUserMapper;
import com.example.application.service.AccountBookService;

/**
* 貯金の一覧画面を制御する
*
*/
@Controller
@RequestMapping("/accountBook")
public class AccountBookController {

	@Autowired
	private AccountBookService service;

	@Autowired
	private SiteUserMapper siteUserMapper;

	/**
	* 一覧表示
	* @param model
	* @return html accountBook/list
	*/
	@GetMapping
	public String list(Model model, Authentication user) {

		//ログインユーザー情報を取得
		SiteUser loginUser = siteUserMapper.getLoginUser(user.getName());
		//支出入を取得
		List<AccountBook> accountBooks = service.getAccountBookList(loginUser.getId());

		//合計収入を計算
		int totalIncome = service.sumIncome(accountBooks);
		//合計支出を計算
		int totalCost = service.sumCost(accountBooks);

		model.addAttribute("accountBooks", accountBooks);
		model.addAttribute("totalIncome", totalIncome);
		model.addAttribute("totalCost", totalCost);
		model.addAttribute("totalMoney", totalIncome - totalCost);

		return "accountBook/list";
	}

	/**
	* Form画面表示(新規登録用)
	* @param model
	* @param accountBookForm
	* @return html accountBook/form
	*/
	@GetMapping("/form")
	public String getForm(Model model, AccountBookForm accountBookForm) {

		// savingFormを新規登録のために、trueを格納
		accountBookForm.setNewAccountBook(true);

		// カテゴリー一覧を取得し,Formクラスに格納
		List<Category> categories = service.getCategoryAll();
		accountBookForm.setCategories(categories);

		model.addAttribute("title", "新規Form");

		return "accountBook/form";
	}

	/**
	* 入出金データ１件の登録
	* @param model
	* @param accountBookForm
	* @return redirect:/accountBook
	*/
	@PostMapping("/insert")
	public String insert(Model model,
			AccountBookForm accountBookForm,
			Authentication user) {

		//ログインユーザー情報を取得
		SiteUser loginUser = siteUserMapper.getLoginUser(user.getName());
		//User_idをFormクラスにセット
		accountBookForm.setUser_id(loginUser.getId());

		//entityに変換後、登録処理
		AccountBook accountBook = makeSaving(accountBookForm);
		service.insert(accountBook);

		return "redirect:/accountBook";
	}

	/**
	* 1件のレコードを取得し,Form画面に表示(更新処理用)
	* @param model
	* @param @PathVariable("id") int id
	* @return html accountBook/form
	*/
	@GetMapping("/edit/{id}")
	public String form(Model model,
			@PathVariable("id") int id,
			RedirectAttributes redirectAttributes,
			Authentication user) {

		// 更新対象を取得
		AccountBook accountBook = service.getAccountBook(id);

		//ログインユーザー情報を取得
		SiteUser loginUser = siteUserMapper.getLoginUser(user.getName());
		if (Objects.isNull(accountBook) || loginUser.getId() != accountBook.getUser_id()) {
			redirectAttributes.addFlashAttribute("loginUserCheck", "アクセスできません");
			return "redirect:/accountBook";
		}

		// 取得したデータを変換する
		AccountBookForm accountBookForm = makeSavingForm(accountBook);
		// savingFormを更新のために、falseを格納
		accountBookForm.setNewAccountBook(false);

		// カテゴリー一覧を取得し,Formクラスに格納
		List<Category> categories = service.getCategoryAll();
		accountBookForm.setCategories(categories);

		model.addAttribute("title", "更新form");
		model.addAttribute(accountBookForm);

		return "accountBook/form";
	}

	/**
	* 入出金データ１件の更新
	* @param model
	* @param accountBookForm
	* @return redirect:/accountBook
	*/
	@PostMapping("/update")
	public String update(Model model, AccountBookForm accountBookForm) {

		AccountBook accountBook = makeSaving(accountBookForm);
		service.updateAccountBook(accountBook);

		return "redirect:/accountBook";

	}

	/**
	* 入出金データ１件の削除
	* @param model
	* @param @PathVariable("id") int id
	* @return redirect:/saving
	*/
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") int id) {

		service.deleteAccountBook(id);

		return "redirect:/accountBook";

	}

	/**
	* AccountBookForm(Form)からAccountBook(entity)に変換
	* @param accountBookForm
	* @return accountBook
	*/
	public AccountBook makeSaving(AccountBookForm accountBookForm) {

		AccountBook accountBook = new AccountBook();

		accountBook.setId(accountBookForm.getId());
		accountBook.setUser_id(accountBookForm.getUser_id());
		accountBook.setRecode_date(accountBookForm.getRecode_date());
		accountBook.setCategory_id(accountBookForm.getCategory_id());
		accountBook.setMoney(accountBookForm.getMoney());
		accountBook.setIncome_cost_flg(accountBookForm.getIncome_cost_flg());
		accountBook.setNote(accountBookForm.getNote());

		return accountBook;
	}

	/**
	* AccountBook(entity)からAccountBookForm(Form)に変換
	* @param accountBook
	* @return accountBookForm
	*/
	public AccountBookForm makeSavingForm(AccountBook accountBook) {

		AccountBookForm accountBookForm = new AccountBookForm();

		accountBookForm.setId(accountBook.getId());
		accountBookForm.setUser_id(accountBook.getUser_id());
		accountBookForm.setRecode_date(accountBook.getRecode_date());
		accountBookForm.setCategory_id(accountBook.getCategory_id());
		accountBookForm.setMoney(accountBook.getMoney());
		accountBookForm.setIncome_cost_flg(accountBook.getIncome_cost_flg());
		accountBookForm.setNote(accountBook.getNote());

		return accountBookForm;
	}

}

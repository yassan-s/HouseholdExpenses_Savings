package com.example.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.application.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //フォームの値と比較するDBから取得したパスワードは暗号化されているのでフォームの値も暗号化するために利用
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                            "/images/**",
                            "/css/**",
                            "/javascript/**"
                            );
    }

    //URLによって認証が必要なのかどうかを定義
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//リクエスト時に認証が必要かを定義
			.authorizeRequests()
				//認証が必要ない
				.antMatchers("/", "/signup").permitAll()
				//上記以外は認証が必要
				.anyRequest().authenticated()
				.and()
			//フォームベース認証の設定
			.formLogin()
				//ログインページはコントローラを経由しないのでViewNameとの紐付けが必要
				.loginPage("/login")
				//フォームのSubmitURL、このURLへリクエストが送られると認証処理が実行される
				.loginProcessingUrl("/sign_in")
				//認証後にリダイレクトするURL先を指定
				.defaultSuccessUrl("/accountBook")
				//リクエストパラメータのname属性を明示
				.usernameParameter("name")
				.passwordParameter("password")
				.failureUrl("/login?error")
				//全てのユーザーにアクセスの許可
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
			//rememberMeの有効化
			.rememberMe()
				;
		//h2dbをブラウザで見れるようにする
		//他のサイトから操作できる可能性があるので、最終的に消すこと
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

    //ユーザー情報の取得
    //認証を行う
    //その際、パスワードはBCryptでハッシュ化(元の値に変更不可)した値を利用する
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
        		.passwordEncoder(passwordEncoder());
    }

}

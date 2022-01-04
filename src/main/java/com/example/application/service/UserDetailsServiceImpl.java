package com.example.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.application.entity.SiteUser;
import com.example.application.mapper.SiteUserMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //DBからユーザ情報を検索するメソッドを実装したクラス
    @Autowired
    private SiteUserMapper siteUserMapper;

    //暗号化するために使用
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

    	//Mapperの検索メソッドを実行し、ユーザー情報を取得
        SiteUser loginUser = siteUserMapper.getLoginUser(name);

        //UsernameNotFoundExceptionで例外処理
        if (loginUser == null) {
            throw new UsernameNotFoundException("User" + name + "was not found in the database");
        }
        //権限のリスト
        //AdminやUserなどが存在するが、今回は利用しないのでUSERのみを仮で設定
        //権限を利用する場合は、DB上で権限テーブル、ユーザ権限テーブルを作成し管理が必要
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        grantList.add(authority);

        //UserDetailsはインタフェースなので、Userクラスのコンストラクタで生成したユーザオブジェクトをキャスト
        //org.springframework.security.core.userdetails.User を利用
        UserDetails userDetails = (UserDetails)new User(loginUser.getName(), loginUser.getPassword() ,grantList);

        return userDetails;
    }

    //ユーザーを新規登録
    public void register(SiteUser user) {

    	//パスワードをハッシュ化
    	user.setPassword(encoder.encode(user.getPassword()));
    	//パスワードを確認
    	System.out.println("パスワードは " + user.getPassword());

    	//ユーザーの新規登録処理を実行
    	siteUserMapper.insertNewUser(user);
    }

}

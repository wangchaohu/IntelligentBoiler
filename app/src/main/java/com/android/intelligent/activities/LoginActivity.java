package com.android.intelligent.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.android.intelligent.base.BaseActivity;
import com.android.intelligent.interfaces.LoginActivityInterface;
import com.android.intelligent.presenter.LoginPresenter;
import com.android.intelligent.R;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class LoginActivity extends BaseActivity implements LoginActivityInterface{

    private LoginPresenter presenter;
    private TextInputEditText user_name;
    private TextInputEditText user_password;
    private Button login_Btn;
    private TextView forgetPw_Tv;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        initToolBar("登录");
        init();
        setLoginPresenter(this);
    }

    @Override
    public void init() {
        user_name = (TextInputEditText) findViewById(R.id.user_name);
        user_password = (TextInputEditText) findViewById(R.id.user_password);
        login_Btn = (Button) findViewById(R.id.login_btn);
        login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_name.getText().toString();
                String password = user_password.getText().toString();
                if ("".equals(username)){
                    user_name.setError("手机号不能为空！！！");
                }else if ("".equals(password)){
                    user_password.setError("密码不能为空！！！");
                }else {
                    presenter.login(username, password);
                }
            }
        });

        forgetPw_Tv = (TextView) findViewById(R.id.forgetPw_Tv);
        forgetPw_Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.forgot();
            }
        });
    }

    @Override
    public void setLoginPresenter(LoginActivity loginView) {
        presenter = new LoginPresenter(this, this);
    }

    @Override
    public void loginError() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void toOtherActivity(Class activity) {
        startActivity(new Intent(LoginActivity.this, activity));
    }
}

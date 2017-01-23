package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.interfaces.LoginActivityInterface;
import com.lapsen.intelligentboiler.presenter.LoginPresenter;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class LoginActivity extends BaseActivity implements LoginActivityInterface{

    private LoginPresenter presenter;
    private TextInputEditText user_name;
    private TextInputEditText user_password;
    private Button login_Btn;

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
}

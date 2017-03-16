package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.interfaces.ForgotPasswordInterface;
import com.lapsen.intelligentboiler.presenter.ForgotPasswordPresenter;

/**
 * Created by lapsen_wang on 2017/3/15/0015.
 */

public class ForgottenPasswordActivity extends BaseActivity implements ForgotPasswordInterface{

    private TextInputEditText phone,verification_code, new_pw, repeat_new_pw;
    private Button forgot_btn, getCode;

    private ForgotPasswordPresenter presenter;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_forgotpw);
        initToolBar("忘记密码");
        initPresenter();
        init();

    }

    /**
     * 初始化组件
     * */
    private void init(){
        phone = (TextInputEditText) findViewById(R.id.phone);
        verification_code = (TextInputEditText) findViewById(R.id.verification_code);
        new_pw = (TextInputEditText) findViewById(R.id.new_pw);
        repeat_new_pw = (TextInputEditText) findViewById(R.id.repeat_new_pw);
        getCode = (Button) findViewById(R.id.code_btn);
        forgot_btn = (Button) findViewById(R.id.forgot_btn);

        /*获取验证码*/
        getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    presenter.getCode(phone.getText().toString());
            }
        });
        /*忘记密码*/
        forgot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    presenter.forgot(phone.getText().toString(), verification_code.getText().toString(), new_pw.getText().toString(), repeat_new_pw.getText().toString());
            }
        });
    }

    /**
     * 初始化presenter
     * */
    @Override
    public void initPresenter(){
        this.presenter = new ForgotPasswordPresenter(this);
    }

    @Override
    public void phoneError() {
        if (null != phone) {
            phone.setError("手机号不能为空");
        }
    }

    @Override
    public void codeError() {
        if (null != verification_code) {
            verification_code.setError("验证码不能为空");
        }
    }

    @Override
    public void newPwError() {
        if (null != new_pw) {
            new_pw.setError("新密码不能为空");
        }
    }

    @Override
    public void repeatPwError() {
        if (null != repeat_new_pw) {
            repeat_new_pw.setError("重复密码不能为空");
        }
    }
}

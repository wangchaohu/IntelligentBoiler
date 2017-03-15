package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;

/**
 * Created by lapsen_wang on 2017/3/15/0015.
 */

public class ForgottenPasswordActivity extends BaseActivity {

    private TextInputEditText phone,verification_code, new_pw, repeat_new_pw;
    private Button forgot_btn;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_forgotpw);
        initToolBar("忘记密码");
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
        forgot_btn = (Button) findViewById(R.id.forgot_btn);
    }


}

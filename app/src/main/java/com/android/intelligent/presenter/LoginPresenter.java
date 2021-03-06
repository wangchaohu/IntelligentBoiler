package com.android.intelligent.presenter;

import android.content.Context;
import android.widget.Toast;

import com.android.intelligent.activities.ForgottenPasswordActivity;
import com.android.intelligent.activities.LoginActivity;

/**
 * Created by lapsen_wang on 2017/1/23/0023.
 */

public class LoginPresenter {

    private Context mContext;
    private LoginActivity loginView;

    public LoginPresenter(Context context, LoginActivity loginView){
        this.mContext = context;
        this.loginView = loginView;
    }


    public void login(String username, String password){
        Toast.makeText(mContext, username + "--->" + password, Toast.LENGTH_SHORT).show();
    }

    /**
     * 忘记密码
     * */
    public void forgot(){
        loginView.toOtherActivity(ForgottenPasswordActivity.class);
    }
}

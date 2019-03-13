package com.android.intelligent.presenter;

import android.widget.Toast;

import com.android.intelligent.activities.ForgottenPasswordActivity;

/**
 * Created by lapsen_wang on 2017/3/16/0016.
 */

public class ForgotPasswordPresenter {

    private ForgottenPasswordActivity forgotPasswordView;

    public ForgotPasswordPresenter(ForgottenPasswordActivity forgotPasswordView){
        this.forgotPasswordView = forgotPasswordView;
    }

    /**
     * 使用手机号获取验证码
     * @param phone
     * */
    public void getCode(String phone){
        if ("".equals(phone)) {
            forgotPasswordView.phoneError();
        }else {
            Toast.makeText(forgotPasswordView, "验证码已发送到" + phone + "，请注意查收", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 验证密码
     * @param phone    手机号
     * @param code     验证码
     *                 @param newPw    新密码
     *                                 @param  repeatPw   重复密码
     * */
    public void forgot(String phone, String code, String newPw, String repeatPw) {
        if ("".equals(phone)) {
            forgotPasswordView.phoneError();
        } else if ("".equals(code)) {
            forgotPasswordView.codeError();
        } else if ("".equals(newPw)) {
            forgotPasswordView.newPwError();
        } else if ("".equals(repeatPw)) {
            forgotPasswordView.repeatPwError();
        } else if (!newPw.equals(repeatPw)) {
            Toast.makeText(forgotPasswordView, "两次密码不一样，请重新输入", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(forgotPasswordView, "密码已重置,请返回重新登录", Toast.LENGTH_SHORT).show();
            forgotPasswordView.finish();
        }
    }
}

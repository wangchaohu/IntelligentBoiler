package com.lapsen.intelligentboiler.interfaces;

import android.app.Activity;
import android.content.Intent;

import com.lapsen.intelligentboiler.activities.LoginActivity;

/**
 * Created by lapsen_wang on 2017/1/23/0023.
 */

public interface LoginActivityInterface {
    public void init();
    public void setLoginPresenter(LoginActivity loginView);
    public void loginError();
    public void loginSuccess();
    void toOtherActivity(Class activity);
}

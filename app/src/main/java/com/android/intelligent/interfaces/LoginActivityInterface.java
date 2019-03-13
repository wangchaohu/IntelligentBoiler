package com.android.intelligent.interfaces;

import com.android.intelligent.activities.LoginActivity;

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

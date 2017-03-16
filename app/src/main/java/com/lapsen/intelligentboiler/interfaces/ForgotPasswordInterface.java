package com.lapsen.intelligentboiler.interfaces;

/**
 * Created by lapsen_wang on 2017/3/16/0016.
 */

public interface ForgotPasswordInterface {
    void initPresenter();
    void phoneError();
    void codeError();
    void newPwError();
    void repeatPwError();
}

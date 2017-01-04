package com.lapsen.intelligentboiler.interfaces;

/**
 * Created by wangchaohu on 2017/1/2.
 */

public interface MainActivityInterface {
    public void showProgress();
    public void hideProgress();

    public void toOtherActivity(Class otherActivity);

    public void showDialog();
    public void hideDialog();
}

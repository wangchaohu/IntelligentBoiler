package com.android.intelligent.presenter;

import com.android.intelligent.activities.LoginActivity;
import com.android.intelligent.activities.MainActivity;

/**
 * Created by sks on 2017/1/4.
 */

public class MainPresenter {

    private MainActivity mainView;

    public MainPresenter(MainActivity mainView){
        this.mainView = mainView;
    }

    public void startDemonstrate(){
        if (null != mainView) {
            mainView.showProgress();
            // TODO: 2017/1/4  从本地读取是否已经选择场景,读取完成后隐藏loading
            /**
             * 假设已经有选择的场景
             * */
            mainView.showDialog();
        }
    }

    public void startLoginActivity(){
        mainView.toOtherActivity(LoginActivity.class);
    }
}

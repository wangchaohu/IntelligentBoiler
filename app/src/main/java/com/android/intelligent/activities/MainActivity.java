package com.android.intelligent.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


import com.android.intelligent.base.BaseActivity;
import com.android.intelligent.interfaces.MainActivityInterface;
import com.android.intelligent.presenter.MainPresenter;
import com.android.intelligent.util.SPUtils;
import com.android.intelligent.R;

public class MainActivity extends BaseActivity implements MainActivityInterface{

    private MainPresenter mMainPresenter;
    private ProgressBar mProgressBar;
    private Button demonstrate_Btn, login_Btn;

    private AlertDialog.Builder mDialog;

    private String selectBoiler = "";

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        initToolBar("MainActivity");
        initPresenter();
        init();
    }

    /**
     * 初始化控件
     * */
    private void init(){
        mProgressBar = (ProgressBar) findViewById(R.id.loading_pb);
        demonstrate_Btn = (Button) findViewById(R.id.btn_demonstrate);
        login_Btn = (Button) findViewById(R.id.btn_login);

        demonstrate_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.startDemonstrate();
            }
        });

        login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.startLoginActivity();
            }
        });
    }

    /**
     * 初始化Presenter
     * */
    private void initPresenter(){
        mMainPresenter = new MainPresenter(this);
        selectBoiler = (String) SPUtils.getSharedPreferences(this).get("selectBoiler","您还未选择场景");
    }
    @Override
    public void showProgress() {
        if (null != mProgressBar && !mProgressBar.isShown()){
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (null != mProgressBar && mProgressBar.isShown()){
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void toOtherActivity(Class otherActivity) {
        Intent intent = new Intent(MainActivity.this, otherActivity);
        if (otherActivity != LoginActivity.class){
            //将场景信息传入intent，传递到MajorActivity
            intent.putExtra("BoilerType",selectBoiler);
            this.finish();
        }
        startActivity(intent);
    }

    @Override
    public void showDialog() {
        hideProgress();
        if (null == mDialog){
            mDialog = new AlertDialog.Builder(this);
            mDialog.setMessage(getResources().getString(R.string.dialog_text) +"\n"+ selectBoiler)
                    .setPositiveButton(R.string.dialog_text_yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            toOtherActivity(MajorActivity.class);
                        }
                    })
                    .setNegativeButton(R.string.dialog_text_no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            toOtherActivity(SelectDemonstrateActivity.class);
                        }
                    });
            mDialog.create();
        }
        mDialog.show();
    }

    @Override
    public void hideDialog() {
        if (null != mDialog){
            mDialog = null;
        }
    }
}

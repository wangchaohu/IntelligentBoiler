package com.lapsen.intelligentboiler.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.interfaces.SelectDemonstrateInterface;
import com.lapsen.intelligentboiler.presenter.SelectDemonstratePresenter;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class SelectDemonstrateActivity extends BaseActivity implements SelectDemonstrateInterface {
    private LinearLayout area;
    private LinearLayout project;
    private LinearLayout monitor;

    private RelativeLayout mToolBar;
    private TextView title_Tv;
    private ImageButton return_Btn;



    private boolean isSelect = false;  //判断是否已经选择演示锅炉

    private SelectDemonstratePresenter presenter;



    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_selectdemonstrate);
        initToolBar("监控锅炉选择");
        init();
        initPresenter();
    }

    /**
     * 设置是否已经选择锅炉
     * */
    public void setSelect(boolean select) {
        isSelect = select;
    }

    @Override
    public void initToolBar(String title) {
        mToolBar = (RelativeLayout) findViewById(R.id.toolBar);
        title_Tv = (TextView) findViewById(R.id.title_tv);
        return_Btn = (ImageButton) findViewById(R.id.btn_return);
        if (null != mToolBar){
            mToolBar.setVisibility(View.VISIBLE);
        }
        if (null != title_Tv){
            title_Tv.setText(title);
        }
        if (null != return_Btn){
            return_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isSelect){
                        finish();
                    }else {
                        Toast.makeText(SelectDemonstrateActivity.this, "请选择一台演示锅炉", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    private void init() {
        area = (LinearLayout) findViewById(R.id.area_ll);
        project = (LinearLayout) findViewById(R.id.project_ll);
        monitor = (LinearLayout) findViewById(R.id.monitorboiler_ll);
    }

    private void initPresenter() {
        presenter = new SelectDemonstratePresenter(this, this);
    }

    @Override
    public void showPlace(View childView) {
            area.addView(childView);
    }

    @Override
    public void showProject(View childView) {
        project.addView(childView);
    }

    @Override
    public void showMonitorBoiler(View childView) {
        monitor.addView(childView);
    }

    /**
     * 清除布局中的childView
     * */
    @Override
    public void clearLayout(String type){
        if ("project".equals(type)){                    //判断第二级布局中是否有子view，有的话就清除全部
            if (project.getChildCount()>0){
                project.removeAllViews();
            }
            if (monitor.getChildCount() > 0){
                monitor.removeAllViews();
            }
        }
        if ("boiler".equals(type)){                  //判断第三级布局中是否有子view，有的话就清除全部
            if (monitor.getChildCount()>0){
                monitor.removeAllViews();
            }
        }
    }

    /**
     * 跳转到其他activity
     * */
    @Override
    public void toOtherActivity(Intent intent) {
        intent.setClass(SelectDemonstrateActivity.this, MajorActivity.class);
        this.finish();
        startActivity(intent);
    }
}

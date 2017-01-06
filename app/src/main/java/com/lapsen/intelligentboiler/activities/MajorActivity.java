package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.adapter.GridViewAdapter;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.interfaces.MajorActivityInterface;
import com.lapsen.intelligentboiler.presenter.MajorPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lapsen_wang on 2017/1/5.
 */

public class MajorActivity extends BaseActivity implements MajorActivityInterface{


    private MajorPresenter mMajorPresenter;
    private GridView mGridView;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_major);
        initToolBar("锅炉");
        initGridView();
    }

    /**
     * 初始化控件
     */
    private void initGridView() {
        mGridView = (GridView) findViewById(R.id.major_Gv);
        mMajorPresenter = new MajorPresenter(MajorActivity.this, this);
    }

    @Override
    public void setGridViewAdapter(GridViewAdapter mGridViewAdapter) {
        if (null != mGridView) {
            mGridView.setAdapter(mGridViewAdapter);
        }
    }

    /**
     * 跳转到其他Activity
     * */
    @Override
    public void toOtherActivity(Class otherActivity) {

    }
}

package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.adapter.GridViewAdapter;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.interfaces.MajorActivityInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lapsen_wang on 2017/1/5.
 */

public class MajorActivity extends BaseActivity implements MajorActivityInterface{


    private GridView mGridView;
    private GridViewAdapter mGridViewAdapter;

    private ArrayList<Map<String, Object>> listData = new ArrayList<>();
    private int[] icons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher}; //GridView上的图片
    private String[] texts = {"直接前往", "直接前往", "直接前往", "直接前往", "直接前往", "直接前往"}; //GridView上的文字

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_major);
        initToolBar("锅炉");
        init();
    }

    /**
     * 初始化控件
     */
    private void init() {
        mGridView = (GridView) findViewById(R.id.major_Gv);
        if (null != mGridView) {
            setGridView(mGridView);
        }
    }

    /**
     * 设置GridView
     */

    private void setGridView(GridView mGridView) {

        mGridViewAdapter = new GridViewAdapter(MajorActivity.this, icons, texts);

            mGridView.setAdapter(mGridViewAdapter);
    }

    /**
     * 跳转到其他Activity
     * */
    @Override
    public void toOtherActivity(Class otherActivity) {

    }
}

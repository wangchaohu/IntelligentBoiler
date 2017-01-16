package com.lapsen.intelligentboiler.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.commonadapter.CommonAdapter;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.interfaces.MajorActivityInterface;
import com.lapsen.intelligentboiler.presenter.MajorPresenter;
import com.bigkoo.convenientbanner.ConvenientBanner;

/**
 * Created by lapsen_wang on 2017/1/5.
 */

public class MajorActivity extends BaseActivity implements MajorActivityInterface {


    private MajorPresenter mMajorPresenter;
    private GridView mGridView;
    private ConvenientBanner convenientBanner;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_major);
        initToolBar("锅炉");
        mMajorPresenter = new MajorPresenter(MajorActivity.this, this);
        initGridView();
        initConvenientBanner();
    }

    /**
     * 初始化GridView
     */
    private void initGridView() {
        mGridView = (GridView) findViewById(R.id.major_Gv);
        //使用通用adapter，目前只能使用这个方法来完成item的点击，还不能在adapter中集成
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMajorPresenter.setOtherActivitys(position);
            }
        });
    }

    /**
     * 初始化ConvenientBanner
     */
    private void initConvenientBanner() {
        convenientBanner = (ConvenientBanner) findViewById(R.id.convenientbanner);
        if (null != convenientBanner) {
            mMajorPresenter.setPages(convenientBanner);
        }
    }

    @Override
    public void setGridViewAdapter(CommonAdapter adapter) {
        if (null != mGridView) {
            mGridView.setAdapter(adapter);
        }
    }

    /**
     * 跳转到其他Activity
     */
    @Override
    public void toOtherActivity(Class otherActivity) {
        startActivity(new Intent(MajorActivity.this, otherActivity));
    }
}

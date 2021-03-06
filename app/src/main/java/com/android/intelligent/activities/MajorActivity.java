package com.android.intelligent.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.android.intelligent.commonadapter.CommonAdapter;
import com.android.intelligent.base.BaseActivity;
import com.android.intelligent.interfaces.MajorActivityInterface;
import com.android.intelligent.presenter.MajorPresenter;
import com.android.intelligent.R;
import com.bigkoo.convenientbanner.ConvenientBanner;

/**
 * Created by lapsen_wang on 2017/1/5.
 */

public class MajorActivity extends BaseActivity implements MajorActivityInterface {


    private MajorPresenter mMajorPresenter;
    private GridView mGridView;
    private ConvenientBanner convenientBanner;

    private RelativeLayout mToolBar;
    private TextView title_Tv;
    private ImageButton return_Btn;
    private ViewStub choice_Btn;

    private long firstTime = 0;  //第一次点击返回的时间

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_major);
        initToolBar("场景");
        initGridView();
        mMajorPresenter = new MajorPresenter(MajorActivity.this, this);
        initConvenientBanner();
    }

    /**
     * 重写initToolBar
     * <p>
     * 将choiceButton显示出来
     */
    @Override
    public void initToolBar(String title) {
        mToolBar = (RelativeLayout) findViewById(R.id.toolBar);
        title_Tv = (TextView) findViewById(R.id.title_tv);
        return_Btn = (ImageButton) findViewById(R.id.btn_return);
        return_Btn.setVisibility(View.GONE);
        choice_Btn = (ViewStub) findViewById(R.id.choice_viewStub);

        if (null != mToolBar) {
            mToolBar.setVisibility(View.VISIBLE);
        }
        if (null != title_Tv) {
            title_Tv.setText(title);
        }
        if (null != choice_Btn) {
            choice_Btn.setOnInflateListener(new ViewStub.OnInflateListener() {
                @Override
                public void onInflate(ViewStub stub, View inflated) {
                    inflated.findViewById(R.id.btn_choice).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toOtherActivity(SelectDemonstrateActivity.class);
                            finish();
                        }
                    });
                }
            });
        }
        /**如果viewStub已经被撑开，捕获异常，让其显示*/
        try {
            choice_Btn.inflate();
        } catch (Exception e) {
            choice_Btn.setVisibility(View.VISIBLE);
        }
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

    /**再按一次退出程序*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000){
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            }else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}

package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class SuggestionActivity extends BaseActivity {

    private RelativeLayout mToolBar;
    private TextView title_Tv;
    private ImageButton return_Btn;
    private ViewStub sure_Btn;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_suggestion);
        initToolBar("优化建议");
    }

    /**
     * 重写initToolBar
     * <p>
     * 将sureButton显示出来
     */
    @Override
    public void initToolBar(String title) {
        mToolBar = (RelativeLayout) findViewById(R.id.toolBar);
        title_Tv = (TextView) findViewById(R.id.title_tv);
        return_Btn = (ImageButton) findViewById(R.id.btn_return);
        sure_Btn = (ViewStub) findViewById(R.id.sure_viewStub);

        if (null != mToolBar) {
            mToolBar.setVisibility(View.VISIBLE);
        }
        if (null != title_Tv) {
            title_Tv.setText(title);
        }
        if (null != return_Btn){
            return_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }


        if (null != sure_Btn) {
            /**如果viewStub已经被撑开，捕获异常，让其显示*/
            try {
                sure_Btn.inflate();
            } catch (Exception e) {
                sure_Btn.setVisibility(View.VISIBLE);
            }
            sure_Btn.setOnInflateListener(new ViewStub.OnInflateListener() {
                @Override
                public void onInflate(ViewStub stub, View inflated) {

                }
            });
        }
    }
}

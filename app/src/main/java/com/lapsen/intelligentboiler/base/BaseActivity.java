package com.lapsen.intelligentboiler.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lapsen.intelligentboiler.R;

/**
 * Created by sks on 2017/1/3.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private RelativeLayout mToolBar;
    private TextView title_Tv;
    private ImageButton return_Btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews(savedInstanceState);
    }

    public abstract void initViews(Bundle savedInstanceState);

    public void initToolBar(String title){
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
                    finish();
                }
            });
        }
    }
}

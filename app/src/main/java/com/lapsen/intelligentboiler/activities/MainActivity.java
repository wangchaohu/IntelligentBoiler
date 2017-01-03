package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void initViews(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.initToolBar("首页");
    }
}

package com.android.intelligent.activities;

import android.os.Bundle;

import com.android.intelligent.base.BaseActivity;
import com.android.intelligent.customview.CustomLapsenView;

/**
 * Created by lapsen_wang on 2017/2/10/0010.
 */

public class WelcomeActivity extends BaseActivity {

    private CustomLapsenView customLapsenView;

    @Override
    public void initViews(Bundle savedInstanceState) {
        //setContentView(R.layout.activity_welcome);

        //customLapsenView = (CustomLapsenView) findViewById(R.id.lapsenView);
       // customLapsenView.setParmer(WelcomeActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        customLapsenView = null;
    }
}

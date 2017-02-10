package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.customview.CustomLapsenView;

/**
 * Created by lapsen_wang on 2017/2/10/0010.
 */

public class WelcomeActivity extends BaseActivity {

    private CustomLapsenView customLapsenView;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_welcome);

        customLapsenView = (CustomLapsenView) findViewById(R.id.lapsenView);
    }
}

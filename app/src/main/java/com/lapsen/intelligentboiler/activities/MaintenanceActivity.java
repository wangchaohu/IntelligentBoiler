package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class MaintenanceActivity extends BaseActivity {
    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_maintenance);
        initToolBar("维修保养");
    }
}

package com.android.intelligent.activities;

import android.os.Bundle;


import com.android.intelligent.base.BaseActivity;
import com.android.intelligent.R;

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

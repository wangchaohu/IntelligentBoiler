package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class SuggestionActivity extends BaseActivity {
    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_suggestion);
        initToolBar("优化建议");
    }
}

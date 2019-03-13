package com.android.intelligent.interfaces;

import android.app.Activity;

import com.android.intelligent.commonadapter.CommonAdapter;

/**
 * Created by lapsen_wang on 2017/1/19/0019.
 */

public interface RealTimeMonitorInterface {
    public void setRealTimeMonitorViewAdapter(CommonAdapter adapter);
    public void toOtherActivity(Activity activity);
}

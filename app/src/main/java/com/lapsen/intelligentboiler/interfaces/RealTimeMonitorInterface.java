package com.lapsen.intelligentboiler.interfaces;

import android.app.Activity;

import com.lapsen.intelligentboiler.commonadapter.CommonAdapter;

/**
 * Created by lapsen_wang on 2017/1/19/0019.
 */

public interface RealTimeMonitorInterface {
    public void setRealTimeMonitorViewAdapter(CommonAdapter adapter);
    public void toOtherActivity(Activity activity);
}

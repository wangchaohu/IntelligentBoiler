package com.lapsen.intelligentboiler.interfaces;

import com.lapsen.intelligentboiler.commonadapter.CommonAdapter;

/**
 * Created by wangchaohu on 2017/1/6.
 */

public interface MajorActivityInterface {
    public void setGridViewAdapter(CommonAdapter commonAdapter);
    public void toOtherActivity(Class otherActivity);
}

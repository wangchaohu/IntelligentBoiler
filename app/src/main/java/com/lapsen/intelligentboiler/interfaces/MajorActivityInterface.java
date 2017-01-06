package com.lapsen.intelligentboiler.interfaces;

import com.lapsen.intelligentboiler.adapter.GridViewAdapter;

/**
 * Created by wangchaohu on 2017/1/6.
 */

public interface MajorActivityInterface {
    public void setGridViewAdapter(GridViewAdapter mGridViewAdapter);
    public void toOtherActivity(Class otherActivity);
}

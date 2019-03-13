package com.android.intelligent.interfaces;

import android.content.Intent;
import android.view.View;

/**
 * Created by lapsen_wang on 2017/1/18/0018.
 */

public interface SelectDemonstrateInterface {
    public void showPlace(View childView);
    public void showProject(View childView);
    public void showMonitorBoiler(View childView);
    public void clearLayout(String type);
    public void toOtherActivity(Intent intent);

}

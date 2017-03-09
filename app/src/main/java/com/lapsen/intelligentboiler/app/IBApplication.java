package com.lapsen.intelligentboiler.app;

import android.app.Application;

/**
 * Created by lapsen_wang on 2017/3/9/0009.
 */

public class IBApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
    }
}

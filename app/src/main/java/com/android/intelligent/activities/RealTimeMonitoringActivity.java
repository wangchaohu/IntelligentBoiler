package com.android.intelligent.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;


import com.android.intelligent.base.BaseActivity;
import com.android.intelligent.commonadapter.CommonAdapter;
import com.android.intelligent.interfaces.RealTimeMonitorInterface;
import com.android.intelligent.presenter.RealTimeMonitorPresenter;
import com.android.intelligent.R;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class RealTimeMonitoringActivity extends BaseActivity implements RealTimeMonitorInterface{

    private RealTimeMonitorPresenter presenter;
    private GridView realtime_Gv;
//    private ImageView realtime_Iv;
//    private TextView realtime1_Tv;
//    private TextView realtime2_Tv;
//    private TextView realtime3_Tv;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_realtimemonitor);
        initToolBar("实时监控");
        init();
        setPresenter();
    }

    private void setPresenter(){
        presenter = new RealTimeMonitorPresenter(this, this);
    }

    /**初始化控件*/
    private void init(){
        realtime_Gv = (GridView) findViewById(R.id.grid_view_realtime);
//        realtime_Iv = (ImageView) findViewById(R.id.realtime_grid_Iv);
//        realtime1_Tv = (TextView) findViewById(R.id.realtime1_grid_Tv);
//        realtime2_Tv = (TextView) findViewById(R.id.realtime2_grid_Tv);
//        realtime3_Tv = (TextView) findViewById(R.id.realtime3_grid_Tv);
    }

    @Override
    public void setRealTimeMonitorViewAdapter(CommonAdapter adapter) {
        if (null != adapter){
            realtime_Gv.setAdapter(adapter);
        }
    }

    @Override
    public void toOtherActivity(Activity activity) {

    }
}

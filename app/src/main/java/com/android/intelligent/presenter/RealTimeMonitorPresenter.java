package com.android.intelligent.presenter;

import android.content.Context;


import com.android.intelligent.activities.RealTimeMonitoringActivity;
import com.android.intelligent.commonadapter.CommonAdapter;
import com.android.intelligent.commonadapter.ViewHolder;
import com.android.intelligent.R;

/**
 * Created by lapsen_wang on 2017/1/19/0019.
 */

public class RealTimeMonitorPresenter {

    private Context mContext;
    private RealTimeMonitoringActivity realTimeMonitoringView;


    public RealTimeMonitorPresenter(Context context, RealTimeMonitoringActivity view){
        this.mContext = context;
        this.realTimeMonitoringView = view;
        setAdapter();
    }

    public void setAdapter(){
        realTimeMonitoringView.setRealTimeMonitorViewAdapter(new CommonAdapter(mContext, 6, R.layout.item_realtime_gridview) {
            @Override
            public void convert(ViewHolder helper, int position) {
                helper.setImg(R.id.realtime_grid_Iv, R.mipmap.ic_launcher);
                helper.setText(R.id.realtime1_grid_Tv,"你好");
                helper.setText(R.id.realtime2_grid_Tv, "hello");
                helper.setText(R.id.realtime3_grid_Tv, "world");
            }
        });
    }
}

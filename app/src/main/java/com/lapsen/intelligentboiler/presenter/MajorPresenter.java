package com.lapsen.intelligentboiler.presenter;

import android.content.Context;
import android.widget.Toast;

import com.lapsen.intelligentboiler.activities.MajorActivity;
import com.lapsen.intelligentboiler.adapter.GridViewAdapter;
import com.lapsen.intelligentboiler.interfaces.GridViewItemClickListener;
import com.lapsen.intelligentboiler.models.MajorModel;

/**
 * Created by wangchaohu on 2017/1/6.
 */

public class MajorPresenter {

    private Context mContext;
    private MajorActivity majorView;
    private GridViewAdapter mGridViewAdapter;
    private Class[] otherActivitys;

    public MajorPresenter(Context mContext, MajorActivity majorView){
        this.mContext = mContext;
        this.majorView = majorView;

        setAdapter();
    }

    private void setAdapter(){
        mGridViewAdapter = new GridViewAdapter(mContext, getGridViewIvData(), getGridViewTvData(), new GridViewItemClickListener(){
            @Override
            public void onClickListener(int position) {
//                majorView.toOtherActivity(otherActivitys[position]);
                Toast.makeText(majorView, "ToOtherActivity,," + position, Toast.LENGTH_LONG).show();
            }
        });
        majorView.setGridViewAdapter(mGridViewAdapter);
    }

    /**
     * 得到GridView的图片数据
     * */

    private int[] getGridViewIvData(){


        return MajorModel.icons;
    }

    /**
     * 得到GridView的文字数据
     * */

    private String[] getGridViewTvData(){

        return MajorModel.iconNames;
    }

    /**
     * 得到GridView的要跳转的Activity
     * */

    private void getToOtherActivity(){
        otherActivitys = MajorModel.otherActivities;
    }
}

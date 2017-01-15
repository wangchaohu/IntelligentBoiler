package com.lapsen.intelligentboiler.presenter;

import android.content.Context;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.activities.MajorActivity;
import com.lapsen.intelligentboiler.commonadapter.CommonAdapter;
import com.lapsen.intelligentboiler.commonadapter.ViewHolder;
import com.lapsen.intelligentboiler.models.MajorModel;

import java.util.Arrays;

/**
 * Created by wangchaohu on 2017/1/6.
 */

public class MajorPresenter {

    private Context mContext;
    private MajorActivity majorView;
    private Class[] otherActivitys;

    public MajorPresenter(Context mContext, MajorActivity majorView) {
        this.mContext = mContext;
        this.majorView = majorView;

        setAdapter();
    }

    private void setAdapter() {
        getToOtherActivity();//得到跳转其他activity的acitivy数组

        majorView.setGridViewAdapter(new CommonAdapter(mContext, getGridViewTvData().length, R.layout.item_major_gridview) {
            @Override
            public void convert(ViewHolder helper, final int position) {
                helper.setText(R.id.major_grid_Tv, getGridViewTvData()[position]);
                helper.setImg(R.id.major_grid_Iv, getGridViewIvData()[position]);
            }
        });
    }


    /**
     * 得到GridView的图片数据
     */

    private int[] getGridViewIvData() {


        return MajorModel.icons;
    }

    /**
     * 得到GridView的文字数据
     */

    private String[] getGridViewTvData() {

        return MajorModel.iconNames;
    }

    /**
     * 得到GridView的要跳转的Activity
     */

    private void getToOtherActivity() {
        otherActivitys = MajorModel.otherActivities;
    }

    /**
     *
     * */
    public void setOtherActivitys(int position){
        majorView.toOtherActivity(otherActivitys[position]);
    }
}

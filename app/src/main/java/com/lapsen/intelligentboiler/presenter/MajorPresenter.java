package com.lapsen.intelligentboiler.presenter;

import android.content.Context;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.activities.MajorActivity;
import com.lapsen.intelligentboiler.adapter.GridViewAdapter;

/**
 * Created by wangchaohu on 2017/1/6.
 */

public class MajorPresenter {

    private Context mContext;
    private MajorActivity majorView;
    private GridViewAdapter mGridViewAdapter;

    public MajorPresenter(Context mContext, MajorActivity majorView){
        this.mContext = mContext;
        this.majorView = majorView;

        setAdapter();
    }

    private void setAdapter(){
        mGridViewAdapter = new GridViewAdapter(mContext, getGridViewIvData(), getGridViewTvData());
        majorView.setGridViewAdapter(mGridViewAdapter);
    }

    /**
     * 得到GridView的图片数据
     * */

    private int[] getGridViewIvData(){

        int[] icons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher}; //GridView上的图片
        return icons;
    }

    /**
     * 得到GridView的文字数据
     * */

    private String[] getGridViewTvData(){
        String[] iconNames = {"直接前往", "直接前往", "直接前往", "直接前往", "直接前往", "直接前往"}; //GridView上的文字
        return iconNames;
    }
}

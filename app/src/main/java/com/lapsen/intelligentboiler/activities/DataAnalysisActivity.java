package com.lapsen.intelligentboiler.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class DataAnalysisActivity extends BaseActivity implements View.OnClickListener{

    private TextView year_Tv, month_Tv, day_Tv, today_Tv;
    private ArrayList<TextView> tvLists;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_dataanalysis);
        initToolBar("数据分析");
        init();
    }

    private void init(){
        year_Tv = (TextView) findViewById(R.id.year_Tv);
        year_Tv.setOnClickListener(this);
        month_Tv = (TextView) findViewById(R.id.month_Tv);
        month_Tv.setOnClickListener(this);
        day_Tv = (TextView) findViewById(R.id.day_Tv);
        day_Tv.setOnClickListener(this);
        today_Tv = (TextView) findViewById(R.id.today_Tv);
        today_Tv.setOnClickListener(this);
        //将textView放入集合中，方便对其进行点击颜色设置
        tvLists = new ArrayList<>();
        tvLists.add(year_Tv);
        tvLists.add(month_Tv);
        tvLists.add(day_Tv);
        tvLists.add(today_Tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.year_Tv:
                setTvBg(0);
                break;
            case R.id.month_Tv:
                setTvBg(1);
                break;
            case R.id.day_Tv:
                setTvBg(2);
                break;
            case R.id.today_Tv:
                setTvBg(3);
                break;
        }
    }

    /**改变TextView背景颜色*/
    private void setTvBg(int curBtnTag){

        for (int i = 0; i < tvLists.size(); i++){
            if ( i == curBtnTag){
                tvLists.get(i).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }else {
                tvLists.get(i).setBackgroundColor(getResources().getColor(R.color.text_bg));
            }
        }
    }
}

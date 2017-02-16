package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;
import android.view.View;

import android.widget.GridView;
import android.widget.TextView;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.commonadapter.CommonAdapter;
import com.lapsen.intelligentboiler.presenter.DataAnalysisPresenter;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.formatter.ColumnChartValueFormatter;
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class DataAnalysisActivity extends BaseActivity implements View.OnClickListener{

    private TextView year_Tv, month_Tv, day_Tv, today_Tv;
    private ArrayList<TextView> tvLists;
    private GridView gridView;
    private DataAnalysisPresenter presenter;
    private ColumnChartView mColumnChartView;

    private String type = "hour";  //图表显示的类型，默认为当日today



    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_dataanalysis);
        initToolBar("数据分析");
        init();
        initPresenter();
    }

    private void init(){
        gridView = (GridView) findViewById(R.id.analysis_Gv);
        year_Tv = (TextView) findViewById(R.id.year_Tv);
        year_Tv.setOnClickListener(this);
        month_Tv = (TextView) findViewById(R.id.month_Tv);
        month_Tv.setOnClickListener(this);
        day_Tv = (TextView) findViewById(R.id.day_Tv);
        day_Tv.setOnClickListener(this);
        today_Tv = (TextView) findViewById(R.id.hour_Tv);
        today_Tv.setOnClickListener(this);
        //将textView放入集合中，方便对其进行点击颜色设置
        tvLists = new ArrayList<>();
        tvLists.add(year_Tv);
        tvLists.add(month_Tv);
        tvLists.add(day_Tv);
        tvLists.add(today_Tv);
        //默认当日数据被点击
        setTvBg(3);
        initChartView();
    }

    private void initChartView(){
        mColumnChartView = (ColumnChartView) findViewById(R.id.columnChartView);
        if (null != mColumnChartView){
            mColumnChartView.setValueTouchEnabled(true);
        }
    }

    public void showChart(ColumnChartData data){
        mColumnChartView.setColumnChartData(data);
    }

    /**初始化Presenter*/
    private void initPresenter(){
        presenter = new DataAnalysisPresenter();
        presenter.setDataAnalysisView(this);
        presenter.setAdapter();
        //展示图表
        presenter.setChartData(type);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.year_Tv:
                setTvBg(0);
                type = "year";
                break;
            case R.id.month_Tv:
                setTvBg(1);
                type = "month";
                break;
            case R.id.day_Tv:
                setTvBg(2);
                type = "day";
                break;
            case R.id.hour_Tv:
                setTvBg(3);
                type = "hour";
                break;
        }
        presenter.setChartData(type);

    }

    /**适配器*/
    public void setGridViewAdapter(CommonAdapter adapter){
        gridView.setAdapter(adapter);
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

package com.android.intelligent.activities;

import android.os.Bundle;
import android.view.View;

import android.widget.GridView;
import android.widget.TextView;

import com.android.intelligent.base.BaseActivity;
import com.android.intelligent.commonadapter.CommonAdapter;
import com.android.intelligent.interfaces.DataAnalysisStrategy;
import com.android.intelligent.presenter.DataAnalysisPresenter;
import com.android.intelligent.realize.DayDataStrategyImpl;
import com.android.intelligent.realize.HourDataStrategyImpl;
import com.android.intelligent.realize.MonthDataStrategyImpl;
import com.android.intelligent.realize.YearDataStrategyImpl;
import com.android.intelligent.R;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.view.ColumnChartView;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class DataAnalysisActivity extends BaseActivity implements View.OnClickListener{

    private TextView year_Tv, month_Tv, day_Tv, hour_Tv;
    private ArrayList<TextView> tvLists;
    private GridView gridView;
    private DataAnalysisPresenter presenter;
    private ColumnChartView mColumnChartView;
    private DataAnalysisStrategy strategy;



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
        hour_Tv = (TextView) findViewById(R.id.hour_Tv);
        hour_Tv.setOnClickListener(this);

        //将textView放入集合中，方便对其进行点击颜色设置
        tvLists = new ArrayList<>();
        tvLists.add(year_Tv);
        tvLists.add(month_Tv);
        tvLists.add(day_Tv);
        tvLists.add(hour_Tv);
        initChartView();
        //默认当天数据显示
        setTvBg(2);
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
        presenter.show(DayDataStrategyImpl.getInstance());   //默认显示当天的数据
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.year_Tv:
                setTvBg(0);
                strategy = YearDataStrategyImpl.getInstance();
                break;
            case R.id.month_Tv:
                setTvBg(1);
                strategy = MonthDataStrategyImpl.getInstance();
                break;
            case R.id.day_Tv:
                setTvBg(2);
                    strategy = DayDataStrategyImpl.getInstance();
                break;
            case R.id.hour_Tv:
                setTvBg(3);
                    strategy = HourDataStrategyImpl.getInstance();
                break;
        }
        presenter.show(strategy);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        strategy = null;
        mColumnChartView = null;
        presenter = null;
    }
}

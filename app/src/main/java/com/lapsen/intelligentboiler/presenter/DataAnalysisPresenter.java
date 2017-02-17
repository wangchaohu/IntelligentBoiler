package com.lapsen.intelligentboiler.presenter;


import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.activities.DataAnalysisActivity;
import com.lapsen.intelligentboiler.commonadapter.CommonAdapter;
import com.lapsen.intelligentboiler.commonadapter.ViewHolder;
import com.lapsen.intelligentboiler.models.DataAnalysisModel;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;

/**
 * Created by lapsen_wang on 2017/2/15/0015.
 */

public class DataAnalysisPresenter {
    private DataAnalysisActivity dataAnalysisView = null;

    private ColumnChartData data;
    private int numColumns = 0;   //控制列数
    private String[] data_Gv = {};

    public void setDataAnalysisView(DataAnalysisActivity dataAnalysisView) {
        this.dataAnalysisView = dataAnalysisView;
    }

    private void getData(String type) {

        if ("year".equals(type)) {
            data_Gv = DataAnalysisModel.yearData_Gv_content;
        }
        if ("month".equals(type)) {
            data_Gv = DataAnalysisModel.monthData_Gv_content;
        }
        if ("day".equals(type)) {
            data_Gv = DataAnalysisModel.dayData_Gv_content;
        }
        if ("hour".equals(type)) {
            data_Gv = DataAnalysisModel.hourData_Gv_content;
        }
    }

    public void setAdapter() {
        if (null != dataAnalysisView) {
            dataAnalysisView.setGridViewAdapter(new CommonAdapter(dataAnalysisView, 12, R.layout.item_dataanalysis_gridview) {
                @Override
                public void convert(ViewHolder helper, int position) {
                    helper.setText(R.id.analysis_up_Tv, DataAnalysisModel.data_Gv_title[position]);
                    if (data_Gv.length != 0) {
                        helper.setText(R.id.analysis_down_Tv, data_Gv[position]);
                    }
                }
            });
        }
    }

    public void setChartData(String chartType) {
        float[] values = {};
        //判断显示哪种图标
        if ("year".equals(chartType)) {                  //年
            numColumns = 12;
            values = DataAnalysisModel.yearData_Data;

        } else if ("month".equals(chartType)) {          //月
            values = DataAnalysisModel.monthData_Data;
        } else if ("day".equals(chartType)) {           //日
            values = DataAnalysisModel.dayData_Data;
        } else if ("hour".equals(chartType)) {         //小时
            values = DataAnalysisModel.hourData_Data;
        }
        //得到下方GridView的在选择不同时间的数据
        getData(chartType);
        numColumns = values.length;
        if (null != dataAnalysisView) {
            dataAnalysisView.showChart(generateData(numColumns, values));
        }
    }

    //填充数据
    private ColumnChartData generateData(int num, float[] dataValues) {
        int numSubcolumns = 1;  //表示每一列有几个数值
        List<Column> columns = new ArrayList<>();
        List<SubcolumnValue> values;
        for (int i = 0; i < num; i++) {
            values = new ArrayList<>();
            float value = dataValues[i];
            for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue(value, ChartUtils.pickColor()));
            }

            Column column = new Column(values);
            column.setHasLabels(false);   //是否在柱形图上面显示数值
            column.setHasLabelsOnlyForSelected(true);  //是否点击柱形图显示数值
            columns.add(column);
            data = new ColumnChartData(columns);

            //设置行标题和列标题
            Axis axisX = new Axis();
            Axis axisY = new Axis().setHasLines(true);
            axisX.setName("   ");  //x轴名称
            axisY.setName("   ");  //y轴名称
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
        }
        return data;
    }
}


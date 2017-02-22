package com.lapsen.intelligentboiler.interfaces;

import java.util.List;

import lecho.lib.hellocharts.model.ColumnChartData;

/**
 * Created by lapsen_wang on 2017/2/22/0022.
 */

public interface DataAnalysisStrategy {
    List getData();
    ColumnChartData displayChartData(List<Float> dataList);      //返回图表中的数据
    List<String> displayData();         //返回下方gv中的数据
}

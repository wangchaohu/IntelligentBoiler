package com.android.intelligent.realize;

import com.android.intelligent.interfaces.DataAnalysisStrategy;
import com.android.intelligent.models.DataAnalysisModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;

/**
 * Created by lapsen_wang on 2017/2/22/0022.
 */

public class DayDataStrategyImpl implements DataAnalysisStrategy {
    private ColumnChartData data;

    private DayDataStrategyImpl(){}
    private static class Holder{
        private final static DayDataStrategyImpl instance = new DayDataStrategyImpl();
    }
    public static DayDataStrategyImpl getInstance(){
        return Holder.instance;
    }

    /*返回需要填充的数据*/
    @Override
    public List<Float> getData() {
        return DataAnalysisModel.dayData_Data;
    }
    @Override
    public ColumnChartData displayChartData(List dataList) {
        int numSubColumns = 1;  //表示每一列有几个数值
        int size = dataList.size();
        List<Column> columns = new ArrayList<>(size);
        List<SubcolumnValue> values;
        for (int i = 0; i < size; i++) {
            values = new ArrayList<>(numSubColumns);
            float value = (float)dataList.get(i);
            for (int j = 0; j < numSubColumns; ++j) {
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

            axisX.setHasTiltedLabels(true);    //X坐标轴字体是斜的显示还是直的，true是斜的显示
            List<AxisValue> avList = new ArrayList<>(size);
            for (int n = 1; n <= size; n++){
                avList.add(new AxisValue(n-1).setLabel(n + "时"));   //设置x轴的标注
            }
            axisX.setValues(avList);    //设置x轴的标注
            axisX.setName("   ");  //x轴名称
            axisY.setName("   ");  //y轴名称
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
        }
        return data;
    }

    @Override
    public List<String> displayData() {
        return Arrays.asList(DataAnalysisModel.dayData_Gv_content);
    }
}

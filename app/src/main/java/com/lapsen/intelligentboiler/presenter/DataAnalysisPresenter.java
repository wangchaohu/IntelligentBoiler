package com.lapsen.intelligentboiler.presenter;


import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.activities.DataAnalysisActivity;
import com.lapsen.intelligentboiler.commonadapter.CommonAdapter;
import com.lapsen.intelligentboiler.commonadapter.ViewHolder;
import com.lapsen.intelligentboiler.interfaces.DataAnalysisStrategy;
import com.lapsen.intelligentboiler.models.DataAnalysisModel;
import com.lapsen.intelligentboiler.realize.DayDataStrategyImpl;
import com.lapsen.intelligentboiler.realize.HourDataStrategyImpl;
import com.lapsen.intelligentboiler.realize.MonthDataStrategyImpl;
import com.lapsen.intelligentboiler.realize.YearDataStrategyImpl;


/**
 * Created by lapsen_wang on 2017/2/15/0015.
 */

public class DataAnalysisPresenter {
    private DataAnalysisActivity dataAnalysisView = null;

    public void setDataAnalysisView(DataAnalysisActivity dataAnalysisView) {
        this.dataAnalysisView = dataAnalysisView;
    }

    /**
     * fun:显示数据分析中的图表和数据
     * */
    public void show(final DataAnalysisStrategy strategy){
        if (null != dataAnalysisView) {
            /*下方GridView中的数据*/
            dataAnalysisView.setGridViewAdapter(new CommonAdapter(dataAnalysisView, 12, R.layout.item_dataanalysis_gridview) {
                @Override
                public void convert(ViewHolder helper, int position) {
                    helper.setText(R.id.analysis_up_Tv, DataAnalysisModel.data_Gv_title[position]);
                    if (strategy.displayData().size() != 0) {
                        helper.setText(R.id.analysis_down_Tv, strategy.displayData().get(position));
                    }
                }
            });
            /*上方图表中的数据*/
            dataAnalysisView.showChart(strategy.displayChartData(strategy.getData()));
        }
    }
}


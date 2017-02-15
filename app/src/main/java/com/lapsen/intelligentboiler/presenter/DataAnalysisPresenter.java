package com.lapsen.intelligentboiler.presenter;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.activities.DataAnalysisActivity;
import com.lapsen.intelligentboiler.commonadapter.CommonAdapter;
import com.lapsen.intelligentboiler.commonadapter.ViewHolder;

/**
 * Created by lapsen_wang on 2017/2/15/0015.
 */

public class DataAnalysisPresenter {
    private DataAnalysisActivity dataAnalysisView = null;

    public void setDataAnalysisView(DataAnalysisActivity dataAnalysisView){
        this.dataAnalysisView = dataAnalysisView;
    }

    public void setAdapter(){
        if (null != dataAnalysisView){
            dataAnalysisView.setGridViewAdapter(new CommonAdapter(dataAnalysisView, 12, R.layout.item_dataanalysis_gridview){
                @Override
                public void convert(ViewHolder helper, int position) {
                    helper.setText(R.id.analysis_up_Tv, "锅炉平均出力");
                    helper.setText(R.id.analysis_down_Tv, "52.56 MW");
                }
            });
        }
    }
}


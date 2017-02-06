package com.lapsen.intelligentboiler.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.activities.SelectDemonstrateActivity;
import com.lapsen.intelligentboiler.beans.JsonBean;
import com.lapsen.intelligentboiler.models.SelectDemonstrateModel;

import java.util.List;

/**
 * Created by lapsen_wang on 2017/1/18/0018.
 */

public class SelectDemonstratePresenter {

    private SelectDemonstrateActivity selectDemonstrateView;
    private Context mContext;
    private List<JsonBean.ResultBean> city_lists;   //第一级
    private List<JsonBean.ResultBean.ProjectBean> project_lists;  //第二级
    private List<JsonBean.ResultBean.ProjectBean.MonitorBoilerBean> boiler_lists; //第三极

    public SelectDemonstratePresenter(Context context, SelectDemonstrateActivity view) {
        this.mContext = context;
        this.selectDemonstrateView = view;

        //json解析
        analysisJson();
        showPlace();
    }

    /**解析json数据*/
    private void analysisJson() {

        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(SelectDemonstrateModel.json_Data, JsonBean.class);
        if (null != jsonBean && "200".equals(jsonBean.getStatus())) {
            city_lists = jsonBean.getResult();
        }
    }

    private void showPlace() {

        if (null != city_lists &&!city_lists.isEmpty()) {
            for (int i = 0; i < city_lists.size(); i++) {
                project_lists = city_lists.get(i).getProject();
                View view = addButton(city_lists.get(i).getCity());
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showProject(project_lists);
                        v.setBackgroundResource(R.drawable.selected);
                        v.setClickable(false);
                    }
                });
                selectDemonstrateView.showPlace(view);
            }
        }
    }

    private void showProject(List<JsonBean.ResultBean.ProjectBean> project_list) {
        if (null != project_list && !project_list.isEmpty()) {
            for (int i = 0; i < project_list.size(); i++) {
                boiler_lists = project_list.get(i).getMonitorBoiler();
                View view = addButton(project_list.get(i).getProject());
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMonitorBoiler(boiler_lists);
                        v.setClickable(false);
                        v.setBackgroundResource(R.drawable.selected);
                    }
                });
                selectDemonstrateView.showProject(view);
            }
        }
    }

    private void showMonitorBoiler(List<JsonBean.ResultBean.ProjectBean.MonitorBoilerBean> monitorBoilerBeanList) {
        if (null != monitorBoilerBeanList && !monitorBoilerBeanList.isEmpty()) {
            for (int i = 0; i < monitorBoilerBeanList.size(); i++) {
                View view = addButton(monitorBoilerBeanList.get(i).getBoiler());
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击项目之后，跳转到主Activity
                        v.setBackgroundResource(R.drawable.selected);
                    }
                });
                selectDemonstrateView.showMonitorBoiler(view);
            }
        }
    }


    private View addButton(String content) {

        Button button = new Button(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        button.setText(content);
        button.setBackgroundResource(R.drawable.unselected);
        button.setLayoutParams(params);
        return button;
    }
}

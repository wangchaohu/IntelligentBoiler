package com.lapsen.intelligentboiler.presenter;

import android.content.Context;

import android.content.Intent;
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
import com.lapsen.intelligentboiler.util.SPUtils;

import java.util.ArrayList;
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

    private ArrayList<Button> btnLists;   //第一级按钮集合
    private ArrayList<Button> btn2Lists;   //第二级按钮集合

    public SelectDemonstratePresenter(Context context, SelectDemonstrateActivity view) {
        this.mContext = context;
        this.selectDemonstrateView = view;

        //json解析
        analysisJson();
        showPlace();
    }

    /**
     * 解析json数据
     */
    private void analysisJson() {

        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(SelectDemonstrateModel.json_Data, JsonBean.class);
        if (null != jsonBean && "200".equals(jsonBean.getStatus())) {
            city_lists = jsonBean.getResult();
        }
    }

    /**
     * 首先判断布局中是否有其他布局，有就清除全部，没有就添加
     * 将json解析的数据存放在list中
     * 根据list的大小添加按钮
     * 按钮点击事件：将list以及tag传入到下一级
     * tag的作用在于，判断点击的是第几个按钮，
     * 根据tag把其他按钮点击时添加的child view清除
     * 避免点击一个按钮，上一次点击添加的child view依然在布局中
     * */
    private void showPlace() {
        if (null != city_lists && !city_lists.isEmpty()) {
            btnLists = new ArrayList<>();
            for (int i = 0; i < city_lists.size(); i++) {
                View view = addButton(city_lists.get(i).getCity(), i);
                btnLists.add((Button) view);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showProject(city_lists, (int) v.getTag());
                    }
                });
                selectDemonstrateView.showPlace(view);
            }

        }
    }

    private void showProject(List<JsonBean.ResultBean> city_lists, int n) {
        setBtnBg(btnLists, n);    //更改第一级按钮背景颜色
        project_lists = city_lists.get(n).getProject();
        selectDemonstrateView.clearLayout("project");
        btn2Lists = new ArrayList<>();
        for (int i = 0; i < project_lists.size(); i++) {
            View view = addButton(project_lists.get(i).getProject(), i);
            btn2Lists.add((Button) view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMonitorBoiler(project_lists, (int) v.getTag());
                }
            });
            selectDemonstrateView.showProject(view);
        }
    }

    private void showMonitorBoiler(List<JsonBean.ResultBean.ProjectBean> project_lists, int n) {
        setBtnBg(btn2Lists, n);   //更改第二级按钮的背景颜色
        selectDemonstrateView.clearLayout("boiler");
        boiler_lists = project_lists.get(n).getMonitorBoiler();
        for (int i = 0; i < boiler_lists.size(); i++) {
            View view = addButton(boiler_lists.get(i).getBoiler(), i);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("BoilerType", ((Button)v).getText());
                    SPUtils.getSharedPreferences(selectDemonstrateView).put("selectBoiler",((Button)v).getText());
                    selectDemonstrateView.toOtherActivity(intent);
                }
            });
            selectDemonstrateView.showMonitorBoiler(view);

        }
    }


    private View addButton(String content, int i) {
        Button button = new Button(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        params.setMargins(10,5,10,5);
        button.setTag(i);
        button.setText(content);
        button.setPadding(5,0,5,0);
        button.setBackgroundResource(R.drawable.selector_button);
        button.setLayoutParams(params);
        return button;
    }

    /**改变按钮背景颜色*/
    private void setBtnBg(ArrayList<Button> btnLists, int curBtnTag){

        for (int i = 0; i < btnLists.size(); i++){
            if ((int)btnLists.get(i).getTag() == curBtnTag){
                btnLists.get(i).setBackgroundResource(R.drawable.btn_select);
            }else {
                btnLists.get(i).setBackgroundResource(R.drawable.btn_unselect);
            }
        }
    }
}

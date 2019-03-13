package com.android.intelligent.activities;

import android.os.Bundle;


import com.android.intelligent.base.BaseActivity;
import com.android.intelligent.constant.Constant;
import com.android.intelligent.R;

/**
 * Created by lapsen_wang on 2017/3/7/0007.
 */

public class SubPersonalCenterActivity extends BaseActivity {
    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentViewByType(getIntent().getType());
    }

    /**
     * 根据传来的type，选择加载哪一个布局
     * */
    private void setContentViewByType(String type){
        if (Constant.type_projectIntroduction.equals(type)){
            setContentView(R.layout.layout_projectintroduction);
        }else if (Constant.type_boilerIntroduction.equals(type)){
            setContentView(R.layout.layout_boilerintroduction);
        }else if (Constant.type_ec.equals(type)){
            setContentView(R.layout.layout_ec);
        }else if (Constant.type_intellect.equals(type)){
            setContentView(R.layout.layout_intellect);
        }else if (Constant.type_technicalConsultant.equals(type)){
            setContentView(R.layout.layout_technicalconsultant);
        }else if (Constant.type_setting.equals(type)){
            setContentView(R.layout.layout_setting);
        }else if (Constant.type_contact.equals(type)){
            setContentView(R.layout.layout_contact);
        }else {
            return;
        }
        initToolBar(type);
    }
}

package com.lapsen.intelligentboiler.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;
import com.lapsen.intelligentboiler.constant.Constant;

/**
 * Created by lapsen_wang on 2017/1/10/0010.
 */

public class PersonalCenterActivity extends BaseActivity {

    private TextView userName,projectIntroduction,boilerIntroduction,ec,intellect,technicalConsultant,setting,contact;

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_personalcenter);
        initToolBar("个人中心");
        init();
    }



    /**
     * 初始化控件
     * */
    private void init(){
        userName = (TextView) findViewById(R.id.userName_Tv);
        projectIntroduction = (TextView) findViewById(R.id.projectIntroduction_Tv);
        boilerIntroduction = (TextView) findViewById(R.id.boilerIntroduction_Tv);
        ec = (TextView) findViewById(R.id.ec_Tv);
        intellect = (TextView) findViewById(R.id.intellect_Tv);
        technicalConsultant = (TextView) findViewById(R.id.technicalConsultant_Tv);
        setting = (TextView) findViewById(R.id.setting_Tv);
        contact = (TextView) findViewById(R.id.contact_Tv);

        userName.setOnClickListener(new MyOnClickListener());
        projectIntroduction.setOnClickListener(new MyOnClickListener());
        boilerIntroduction.setOnClickListener(new MyOnClickListener());
        ec.setOnClickListener(new MyOnClickListener());
        intellect.setOnClickListener(new MyOnClickListener());
        technicalConsultant.setOnClickListener(new MyOnClickListener());
        setting.setOnClickListener(new MyOnClickListener());
        contact.setOnClickListener(new MyOnClickListener());
    }

    /**
     * 点击事件
     * */
    class MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PersonalCenterActivity.this, SubPersonalCenterActivity.class);
            switch (v.getId()){
                case R.id.userName_Tv:
                    Toast.makeText(PersonalCenterActivity.this,"点击了用户名" ,Toast.LENGTH_SHORT).show();
                break;
                case R.id.projectIntroduction_Tv:
                    Toast.makeText(PersonalCenterActivity.this,"项目介绍" ,Toast.LENGTH_SHORT).show();
                    intent.setType(Constant.type_projectIntroduction);
                    startActivity(intent);
                    break;
                case R.id.boilerIntroduction_Tv:
                    Toast.makeText(PersonalCenterActivity.this,"锅炉介绍" ,Toast.LENGTH_SHORT).show();
                    intent.setType(Constant.type_boilerIntroduction);
                    startActivity(intent);
                    break;
                case R.id.ec_Tv:
                    Toast.makeText(PersonalCenterActivity.this,"环保中心" ,Toast.LENGTH_SHORT).show();
                    intent.setType(Constant.type_ec);
                    startActivity(intent);
                    break;
                case R.id.intellect_Tv:
                    Toast.makeText(PersonalCenterActivity.this,"智能app" ,Toast.LENGTH_SHORT).show();
                    intent.setType(Constant.type_intellect);
                    startActivity(intent);
                    break;
                case R.id.technicalConsultant_Tv:
                    Toast.makeText(PersonalCenterActivity.this,"技术咨询" ,Toast.LENGTH_SHORT).show();
                    intent.setType(Constant.type_technicalConsultant);
                    startActivity(intent);
                    break;
                case R.id.setting_Tv:
                    Toast.makeText(PersonalCenterActivity.this,"设置" ,Toast.LENGTH_SHORT).show();
                    intent.setType(Constant.type_setting);
                    startActivity(intent);
                    break;
                case R.id.contact_Tv:
                    Toast.makeText(PersonalCenterActivity.this,"联系我们" ,Toast.LENGTH_SHORT).show();
                    intent.setType(Constant.type_contact);
                    startActivity(intent);
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        userName = null;
        projectIntroduction=null;boilerIntroduction=null;ec=null;intellect=null;technicalConsultant=null;setting=null;contact=null;
    }
}

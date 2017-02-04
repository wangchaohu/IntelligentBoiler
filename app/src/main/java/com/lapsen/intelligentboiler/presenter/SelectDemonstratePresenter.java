package com.lapsen.intelligentboiler.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.activities.SelectDemonstrateActivity;

/**
 * Created by lapsen_wang on 2017/1/18/0018.
 */

public class SelectDemonstratePresenter {

    private SelectDemonstrateActivity selectDemonstrateView;
    private Context mContext;

    public SelectDemonstratePresenter(Context context, SelectDemonstrateActivity view){
        this.mContext = context;
        this.selectDemonstrateView = view;
        showPlace();
    }

    private void showPlace(){
        View view = addButton();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProject();
                v.setBackgroundResource(R.drawable.selected);
                v.setClickable(false);
            }
        });
        selectDemonstrateView.showPlace(view);
    }

    private void showProject(){
        View view = addButton();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMonitorBoiler();
                v.setClickable(false);
                v.setBackgroundResource(R.drawable.selected);
            }
        });
        selectDemonstrateView.showProject(view);
    }

    private void showMonitorBoiler(){
        View view = addButton();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //点击项目之后，跳转到主Activity
                v.setBackgroundResource(R.drawable.selected);
            }
        });
        selectDemonstrateView.showMonitorBoiler(view);
    }


    private View addButton(){

        Button button = new Button(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setPadding(6, 0, 6, 0);
        button.setText("你好");
        button.setBackgroundResource(R.drawable.unselected);
        button.setLayoutParams(params);
        return button;
    }
}

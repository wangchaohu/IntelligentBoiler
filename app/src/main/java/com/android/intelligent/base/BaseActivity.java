package com.android.intelligent.base;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.intelligent.R;

/**
 * Created by sks on 2017/1/3.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private RelativeLayout mToolBar;
    private TextView title_Tv;
    private ImageButton return_Btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestPermission();     //请求权限
        initViews(savedInstanceState);
    }

    public abstract void initViews(Bundle savedInstanceState);

    public void initToolBar(String title){
        mToolBar = (RelativeLayout) findViewById(R.id.toolBar);
        title_Tv = (TextView) findViewById(R.id.title_tv);
        return_Btn = (ImageButton) findViewById(R.id.btn_return);
        if (null != mToolBar){
            mToolBar.setVisibility(View.VISIBLE);
        }
        if (null != title_Tv){
            title_Tv.setText(title);
        }
        if (null != return_Btn){
            return_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    /**
     * 动态获取权限
     * */
    private void requestPermission(){
        if (Build.VERSION.SDK_INT >= 23){
            int checkPermission = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (checkPermission != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(BaseActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                return;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                //拒绝权限
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("存储权限");
                builder.setMessage("你没有获取存储权限，可能会影响应用的使用");
                builder.setPositiveButton("去获取", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requestPermission();
                    }
                }).setNegativeButton("不获取，继续使用",null);
                builder.create();
                builder.show();
            }
        }
    }
}

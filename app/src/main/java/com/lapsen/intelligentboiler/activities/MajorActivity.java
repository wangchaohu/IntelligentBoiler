package com.lapsen.intelligentboiler.activities;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lapsen_wang on 2017/1/5.
 */

public class MajorActivity extends BaseActivity {


    private GridView mGridView;
    private SimpleAdapter mSimpleAdapter;

    private ArrayList<Map<String, Object>> listData = new ArrayList<>();
    private int[] icons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher}; //GridView上的图片
    private String[] texts = {"直接前往", "直接前往", "直接前往", "直接前往", "直接前往", "直接前往"}; //GridView上的文字

    @Override
    public void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_major);
        initToolBar("锅炉");
        init();
    }

    /**
     * 初始化控件
     */
    private void init() {
        mGridView = (GridView) findViewById(R.id.major_Gv);
        if (null != mGridView) {
            setGridView(mGridView);
        }
    }

    /**
     * 设置GridView
     */

    private void setGridView(GridView mGridView) {

        /**
         * 填充数据
         * */
        if (icons.length == texts.length) {
            for (int i = 0; i < icons.length; i++) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("image", icons[i]);
                map.put("text", texts[i]);
                listData.add(map);
            }
        }

//        if (null != mGridView && listData.size() != 0) {
            mSimpleAdapter = new SimpleAdapter(MajorActivity.this, listData, R.layout.item_major_gridview, new String[]{"image", "text"}, new int[]{R.id.major_grid_Iv, R.id.major_grid_Tv});
            mGridView.setAdapter(mSimpleAdapter);
//        }
    }
}

package com.lapsen.intelligentboiler.models;

import com.lapsen.intelligentboiler.R;
import com.lapsen.intelligentboiler.activities.DataAnalysisActivity;
import com.lapsen.intelligentboiler.activities.MaintenanceActivity;
import com.lapsen.intelligentboiler.activities.PersonalCenterActivity;
import com.lapsen.intelligentboiler.activities.RealTimeMonitoringActivity;
import com.lapsen.intelligentboiler.activities.SecurityAlarmActivity;
import com.lapsen.intelligentboiler.activities.SuggestionActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangchaohu on 2017/1/9.
 */

public class MajorModel {

    public static int[] icons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher}; //GridView上的图片

    public static String[] iconNames = {"实时监控", "数据分析", "优化建议", "维修保养", "安全报警", "个人中心"}; //GridView上的文字

    /**
     * GridView跳转的Activities，横向排列，position依次为
     * 第一行   0，1，2
     * 第二行   3，4，5
     * <p>
     * 实时监控，数据分析，优化建议，
     * 维修保养，安全报警，个人中心
     */
    public static Class[] otherActivities = {RealTimeMonitoringActivity.class, DataAnalysisActivity.class, SuggestionActivity.class,
            MaintenanceActivity.class, SecurityAlarmActivity.class, PersonalCenterActivity.class};


    public static List<Integer> images;

    public static List<Integer> getImages() {
        if (null != images) {
            images = null;
        }
        images = new ArrayList<>();
        for (int img : icons) {
            images.add(img);
        }
        return images;
    }
}

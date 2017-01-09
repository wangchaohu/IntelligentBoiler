package com.lapsen.intelligentboiler.models;

import com.lapsen.intelligentboiler.R;

/**
 * Created by wangchaohu on 2017/1/9.
 */

public class MajorModel {

    public static int[] icons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher}; //GridView上的图片

    public static String[] iconNames = {"直接前往", "直接前往", "直接前往", "直接前往", "直接前往", "直接前往"}; //GridView上的文字

    /**
     * GridView跳转的Activities，横向排列，position依次为
     * 第一行   0，1，2
     * 第二行   3，4，5
     * */
    public static Class[] otherActivities = {};
}

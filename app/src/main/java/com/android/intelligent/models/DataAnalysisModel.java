package com.android.intelligent.models;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lapsen_wang on 2017/2/16/0016.
 */

public class DataAnalysisModel {

    public static List<Float> yearData_Data = Arrays.asList(2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f);    //y轴上数据
    public static  List<Float> monthData_Data = Arrays.asList(2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f,2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f,2.0f, 3.0f, 5f, 15f, 6f, 6f);    //y轴上数据
    public static  List<Float> dayData_Data = Arrays.asList(2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f, 2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f);    //y轴上数据
    public static  List<Float> hourData_Data = Arrays.asList(2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f, 2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f,2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f, 2.0f, 3.0f,5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f, 2.0f, 3.0f, 5f, 15f, 6f, 6f, 34f, 54f, 23f, 84f, 8f, 30f, 2.0f, 3.0f);    //y轴上数据


    /**GridView中的数据*/
    public static  String[] data_Gv_title = {"场景平均出力", "平均负荷率", "累计供热量", "累计运行时间", "累计耗煤量", "场景平均效率", "节煤量", "节煤效益", "尘减排量", "硫减排量", "氮减排量", "碳减排量"};
    public static  String[] yearData_Gv_content = {"41.91 MW", "72.26 %", "508566.22 GJ", "2723.16 H", "21433.83 T", "88.33 %", "5640.04 T", "261.70 万元", "45.68 T", "39.48 T", "32.24 T", "14889.70 T"};


    public static  String[] monthData_Gv_content = {"45.67 MW", "89.57 %", "457832.7 GJ", "3463 H", "5633.64 T", "86.77 %", "6730 T", "300.45 万元", "44.67 T", "35.67 T", "35.43 T", "15373.56 T"};


    public static  String[] dayData_Gv_content = {"13.45 MW", "88.87 %", "3565.65 GJ", "23.56 H", "235.45 T", "89.87 %", "35.6 T", "23.56 万元", "34.65 T", "2.45 T", "5.45 T", "34.4 T"};


    public static  String[] hourData_Gv_content = {"2.91 MW", "89.26 %", "23.22 GJ", "12.16 H", "21.83 T", "88.33 %", "15.04 T", "5.70 万元", "2.68 T", "3.48 T", "1.24 T", "45.70 T"};
}

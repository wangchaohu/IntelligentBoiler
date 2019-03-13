package com.android.intelligent.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by lapsen_wang on 2017/1/18/0018.
 */

public class SPUtils {

    /**
     * 采取IoDH单例模式
     * */

    private static SPUtils spUtils = null;
    private static SharedPreferences mSharedPreferences = null;
    private SharedPreferences.Editor mEditor = null;
    private static String FILE_NAME = "lapsen";

    private SPUtils(Context mContext){
        if (mSharedPreferences == null) {
            mSharedPreferences = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
    }

    public static SPUtils getSharedPreferences(Context mContext){
        if (null == spUtils){
            spUtils = new SPUtils(mContext);
        }
        return spUtils;
    }

    /**
     *保存数据的方法，我们根据得到的不同value，判断存储值得类型
     * @param key   保存数据的key值
     * @param value 保存数据的值，object类型
     * */
    public void put(String key, Object value){
        mEditor = mSharedPreferences.edit();
        if (value instanceof String){
            mEditor.putString(key, (String) value);
        }else if (value instanceof Integer){
            mEditor.putInt(key, (int)value);
        }else if (value instanceof Float){
            mEditor.putFloat(key, (float)value);
        }else if (value instanceof Boolean){
            mEditor.putBoolean(key, (boolean)value);
        }else if (value instanceof Long){
            mEditor.putLong(key, (long)value);
        }else if (value instanceof Set){
            mEditor.putStringSet(key, (Set<String>) value);
        }else {
            mEditor.putString(key, value.toString());
        }
        mEditor.commit();
    }

    /**
     * 得到保存的数据
     * @param key   取得保存数据的key值
     * @param defaultValue  保存数据的默认值
     * */

    public Object get(String key, Object defaultValue){
        if (defaultValue instanceof String){
            return mSharedPreferences.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return mSharedPreferences.getInt(key,(int)defaultValue);
        }else if (defaultValue instanceof Float) {
            return mSharedPreferences.getFloat(key,(float)defaultValue);
        }else if (defaultValue instanceof Long) {
            return mSharedPreferences.getLong(key,(long)defaultValue);
        }else if (defaultValue instanceof Boolean) {
            return mSharedPreferences.getBoolean(key,(boolean)defaultValue);
        }else if (defaultValue instanceof Set) {
            return mSharedPreferences.getStringSet(key,(Set<String>) defaultValue);
        }else {
            return null;
        }
    }
}

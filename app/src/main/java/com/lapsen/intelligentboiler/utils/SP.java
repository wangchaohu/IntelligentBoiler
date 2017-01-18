package com.lapsen.intelligentboiler.utils;

/**
 * Created by lapsen_wang on 2017/1/18/0018.
 */

public class SP {

    /**
     * 采取IoDH单例模式
     * */

    private SP(){

    }

    private static class HolderSP{
        private final static SP spInstance = new SP();
    }

    public static SP getSharedPreferences(){
        return HolderSP.spInstance;
    }
}

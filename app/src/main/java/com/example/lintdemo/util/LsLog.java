package com.example.lintdemo.util;

import android.util.Log;

public final class LsLog {

    public static final boolean IS_ON = false;

    public static void v(String tag, String msg){
        if(IS_ON){
            Log.v(tag, msg);
        }
    }

    public static void vd(String tag, String msg){
        if(IS_ON){
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg){
        if(IS_ON){
            Log.e(tag, msg);
        }
    }

}

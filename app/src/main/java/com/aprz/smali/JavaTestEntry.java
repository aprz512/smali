package com.aprz.smali;

import android.util.Log;

import com.aprz.smali.functions.LogFunc;

/**
 * Created by liyunlei on 2022/8/29.
 * Desc:
 */
public class JavaTestEntry {

    public static void main(String[] args) {
        LogFunc.logInt(32);

        Integer i = 42;
        LogFunc.logInt(i);

        Log.e("aprz-test", "testing...");
    }

}

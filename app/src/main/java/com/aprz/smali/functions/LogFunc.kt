package com.aprz.smali.functions

import android.util.Log

/**
 * Created by liyunlei on 2022/8/26.
 * Desc:
 */
object LogFunc {

    /**
     *  const-string v1, "&&Log&&"
     *  invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
     */

    private const val TAG = "&&Log&&"

    private fun logInt(value: Int) {
        Log.e(TAG, "logInt: $value")
    }

    private fun logDouble(value: Double) {
        Log.e(TAG, "logDouble: $value")
    }

    private fun logFloat(value: Float) {
        Log.e(TAG, "logFloat: $value")
    }

    private fun logString(value: String) {
        Log.e(TAG, "logString: $value")
    }

    private fun logLong(value: Long) {
        Log.e(TAG, "logLong: $value")
    }

    private fun logShort(value: Short) {
        Log.e(TAG, "logShort: $value")
    }

    private fun logChar(value: Char) {
        Log.e(TAG, "logChar: $value")
    }

    private fun logBoolean(value: Boolean) {
        Log.e(TAG, "logBoolean: $value")
    }

    private fun logList(value: List<*>) {
        Log.e(TAG, "logList --- start")
        value.forEach { ele ->
            ele?.apply {
                logObject(this)
            }
        }
        Log.e(TAG, "logList --- end")
    }

    private fun logMap(value: Map<*, *>) {
        Log.e(TAG, "logMap --- start")
        value.entries.forEach { entry ->
            Log.e(
                TAG,
                "key = ${entry.key}, value = ${entry.key}, keyType = ${entry.key!!::class.java.name}, valueType = ${entry.value!!::class.java.name}"
            )
        }
        Log.e(TAG, "logMap --- end")
    }

    @JvmStatic
    fun logObject(obj: Any) {
        when (obj) {
            is Boolean -> logBoolean(obj)
            is Char -> logChar(obj)
            is Short -> logShort(obj)
            is Int -> logInt(obj)
            is Long -> logLong(obj)
            is Float -> logFloat(obj)
            is Double -> logDouble(obj)
            is String -> logString(obj)
            is List<*> -> logList(obj)
            is Map<*, *> -> logMap(obj)
            else -> throw IllegalAccessException("暂不支持Log该类型: ${obj::class.java.name}")
        }
    }

}

fun main() {
    /**
     * 将 LogFunc 的 smali 放入待注入 apk 的 smali 里面，然后需要打印的地方就可以直接调用该代码
     * invoke-static {v0}, Lcom/aprz/smali/functions/LogFunc;->logObject(Ljava/lang/Object;)V
     */
    LogFunc.logObject(45)
}
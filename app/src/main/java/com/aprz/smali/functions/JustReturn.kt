package com.aprz.smali.functions

/**
 * Created by liyunlei on 2022/8/24.
 * Desc:
 */
class JustReturn {

    /*
    '

# virtual methods
.method public final returnFalse()Z
    .registers 2

    .line 10
    const/4 v0, 0x0

    return v0
.end method

.method public final returnTrue()Z
    .registers 2

    .line 14
    const/4 v0, 0x1

    return v0
.end method


     */

    fun returnFalse(): Boolean {
        return false
    }

    fun returnTrue(): Boolean {
        return true
    }

}
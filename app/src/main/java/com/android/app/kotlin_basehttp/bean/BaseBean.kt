package com.android.app.kotlin_basehttp.bean

/**
 * Created by fanhenghao
 */
class BaseBean<T> {

    var code: Int = 0
    var msg: String? = null
    var data: T? = null
}

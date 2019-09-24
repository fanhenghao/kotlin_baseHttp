package com.android.app.kotlin_basehttp.http

/**
 * Created by fanhenghao
 */
class HttpCodeException(code: Int, s: String) : Exception(s) {

    var code: Int = 0
        internal set

    init {
        this.code = code
    }
}

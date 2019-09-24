package com.android.app.kotlin_basehttp.http


import com.android.app.kotlin_basehttp.bean.BaseBean
import io.reactivex.Flowable
import io.reactivex.functions.Function


/**
 * Created by fanhenghao
 */
class AppException<T> : Function<BaseBean<T>, Flowable<T>> {
    override fun apply(baseBean: BaseBean<T>): Flowable<T> {
        return if (baseBean.code != 200) {
            Flowable.error(baseBean.msg?.let { HttpCodeException(baseBean.code, it) })
        } else Flowable.just(baseBean.data!!)
    }
}

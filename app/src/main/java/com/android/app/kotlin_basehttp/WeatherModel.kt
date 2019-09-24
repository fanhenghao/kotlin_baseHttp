package com.android.app.kotlin_basehttp

import com.android.app.kotlin_basehttp.bean.WeatherBean
import com.android.app.kotlin_basehttp.http.AppException
import com.android.app.kotlin_basehttp.http.BaseHttp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber

/**
 * Created by fanhenghao
 */
class WeatherModel : IWeatherModel {
    override fun cityWeather(cityName: String, listener: IWeatherModel.CityWeatherListener) {
        BaseHttp.baseHttp.cityWeather(cityName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) // 请求都完成后，切换到UI线程，将结果进行渲染
                .flatMap(AppException())
                .subscribe(object : ResourceSubscriber<WeatherBean>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: WeatherBean) {
                        listener.responseWeatherSuccess(t)
                    }

                    override fun onError(e: Throwable) {
                        e.message?.let { listener.responseWeatherFail(it) }
                    }

                })
    }
}

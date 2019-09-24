package com.android.app.kotlin_basehttp.http


import com.android.app.kotlin_basehttp.bean.BaseBean
import com.android.app.kotlin_basehttp.bean.WeatherBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * desc:接口请求类
 * Created by fanhenghao
 */

interface NetService {

    /**
     * 请求天气接口
     *
     * @param cityName 城市名称
     */
    @GET("weatherApi")
    fun cityWeather(@Query("city") cityName: String): Flowable<BaseBean<WeatherBean>>

}

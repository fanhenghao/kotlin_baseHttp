package com.android.app.kotlin_basehttp

import com.android.app.kotlin_basehttp.bean.WeatherBean


/**
 * Created by fanhenghao
 */
interface IWeatherModel {

    fun cityWeather(cityName: String, listener: CityWeatherListener)


    interface CityWeatherListener {

        fun responseWeatherSuccess(bean: WeatherBean)

        fun responseWeatherFail(msg: String)
    }

}

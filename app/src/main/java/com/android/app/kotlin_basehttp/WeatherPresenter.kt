package com.android.app.kotlin_basehttp

import android.app.Activity
import com.android.app.kotlin_basehttp.bean.WeatherBean

/**
 * Created by fanhenghao
 */
class WeatherPresenter internal constructor( private val mView: WeatherContract.View) : WeatherContract.Presenter {
    private val mModel: WeatherModel = WeatherModel()

    override fun cityName(cityName: String) {
        mModel.cityWeather(cityName, object : IWeatherModel.CityWeatherListener {
            override fun responseWeatherSuccess(bean: WeatherBean) {
                mView.getCityWeatherSuccess(bean)
            }

            override fun responseWeatherFail(msg: String) {
                mView.getCityWeatherFail(msg)
            }
        })
    }
}

package com.android.app.kotlin_basehttp

import com.android.app.kotlin_basehttp.bean.WeatherBean

/**
 * Created by fanhenghao
 */
interface WeatherContract {
    interface View {
        fun getCityWeatherSuccess(bean: WeatherBean)

        fun getCityWeatherFail(error: String)
    }

    interface Presenter {
        fun cityName(cityName: String)
    }
}

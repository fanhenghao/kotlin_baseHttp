package com.android.app.kotlin_basehttp.bean

/**
 * Created by fanhenghao
 */
class WeatherBean {

    /**
     * yesterday : {"date":"20日星期日","high":"高温 7℃","fx":"北风","low":"低温 -2℃","fl":"<![CDATA[<3级]]>","type":"多云"}
     * city : 南京
     * aqi : null
     * forecast : [{"date":"21日星期一","high":"高温 8℃","fengli":"<![CDATA[<3级]]>","low":"低温 0℃","fengxiang":"西风","type":"多云"},{"date":"22日星期二","high":"高温 10℃","fengli":"<![CDATA[<3级]]>","low":"低温 0℃","fengxiang":"西风","type":"晴"},{"date":"23日星期三","high":"高温 12℃","fengli":"<![CDATA[<3级]]>","low":"低温 1℃","fengxiang":"东北风","type":"晴"},{"date":"24日星期四","high":"高温 8℃","fengli":"<![CDATA[<3级]]>","low":"低温 1℃","fengxiang":"东风","type":"晴"},{"date":"25日星期五","high":"高温 8℃","fengli":"<![CDATA[<3级]]>","low":"低温 2℃","fengxiang":"东北风","type":"多云"}]
     * ganmao : 昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。
     * wendu : 8
     */

    var yesterday: YesterdayBean? = null
    var city: String? = null
    var aqi: Any? = null
    var ganmao: String? = null
    var wendu: String? = null
    var forecast: List<ForecastBean>? = null

    class YesterdayBean {
        /**
         * date : 20日星期日
         * high : 高温 7℃
         * fx : 北风
         * low : 低温 -2℃
         * fl : <![CDATA[<3级]]>
         * type : 多云
         */

        var date: String? = null
        var high: String? = null
        var fx: String? = null
        var low: String? = null
        var fl: String? = null
        var type: String? = null
    }

    class ForecastBean {
        /**
         * date : 21日星期一
         * high : 高温 8℃
         * fengli : <![CDATA[<3级]]>
         * low : 低温 0℃
         * fengxiang : 西风
         * type : 多云
         */

        var date: String? = null
        var high: String? = null
        var fengli: String? = null
        var low: String? = null
        var fengxiang: String? = null
        var type: String? = null
    }

}

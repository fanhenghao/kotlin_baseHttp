package com.android.app.kotlin_basehttp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import com.android.app.kotlin_basehttp.bean.WeatherBean
import com.android.app.kotlin_basehttp.utils.StringUtils
import kotlinx.android.synthetic.main.activity_main.*

class WeatherActivity : AppCompatActivity(), WeatherContract.View {

    private var presenter: WeatherPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = WeatherPresenter( this)
        etCity.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
        })

        btnStart.setOnClickListener {
            val cityName = etCity.text.toString().trim();
            if (TextUtils.isEmpty(cityName)) {
                Toast.makeText(this, "请输入城市名称", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            presenter!!.cityName(cityName)

        }
    }

    @SuppressLint("SetTextI18n")
    override fun getCityWeatherSuccess(bean: WeatherBean) {
        Toast.makeText(this, "网络请求成功", Toast.LENGTH_SHORT).show()
        if (bean.forecast != null) {
            val forecast = bean.forecast
            tvContent.text = bean.forecast!![0].date + "\n" + forecast?.get(0)!!.fengxiang + forecast[0].fengli + "\n" +
                    StringUtils.splitString(forecast[0].low!!) + " ～" + StringUtils.splitString(forecast[0].high!!) + "\n" +
                    forecast[0].type + "\n" + bean.ganmao
        }
    }

    override fun getCityWeatherFail(error: String) {
        Toast.makeText(this, "网络请求失败", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }
}

package com.android.app.kotlin_basehttp.utils

import android.util.Log

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by fanhenghao
 */

class ResponseLog : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        val request = chain.request()

        val t1 = System.nanoTime()//请求发起的时间
        //        Log.e("FHH",String.format("Send Request: %s on %s%n%s", request.url(), chain.connection(), request.headers()));
        Log.e("baseHttp", "------------> " + request.method() + " <------------")
        Log.e("baseHttp", String.format("Send Request----------->: %s", request.url()))
        Log.e("baseHttp", String.format("Request Connection----->: %s", chain.connection()))
        Log.e("baseHttp", String.format("Request Header--------->: %s", request.headers()))
        val response = chain.proceed(request)

        val t2 = System.nanoTime()//收到响应的时间

        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一个新的response给应用层处理
        val responseBody = response.peekBody((1024 * 1024).toLong())
        Log.e("baseHttp", String.format("Response Result----->: %s", response.request().url()))
        Log.e("baseHttp", String.format("Response Json------->:%s", responseBody.string()))
        Log.e("baseHttp", String.format("Response Time------->:%.1fms", (t2 - t1) / 1e6))
        Log.e("baseHttp", String.format("Response Header----->:%s", response.headers()))
        //        Log.e("FHH",String.format("Response Result: [%s] %n return json:%s %.1fms%n%s",
        //                response.request().url(),
        //                responseBody.string(),
        //                (t2 - t1) / 1e6d,
        //                response.headers()));

        return response
    }
}

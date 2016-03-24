package com.example.yhj.kotlindemo.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Yi on 16/3/24.
 */
class RestApi(){
    val api:Api

    init {
        val retrofit=Retrofit.Builder()
                .baseUrl("http://api.huceo.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(OkHttpClient())
                .build()
        api=retrofit.create(Api::class.java)
    }
}
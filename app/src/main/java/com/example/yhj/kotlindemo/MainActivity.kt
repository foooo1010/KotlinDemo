package com.example.yhj.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.yhj.kotlindemo.adapter.NewsAdapter
import com.example.yhj.kotlindemo.api.New
import com.example.yhj.kotlindemo.api.RestApi
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

open class MainActivity : AppCompatActivity() {
    val restApi:RestApi= RestApi()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestNews()

    }
    fun requestNews(){
        restApi.api.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data ->
                    print(message = "success:${data.code}")
                    loadData(data.newslist)
                },{ e ->
                    print(message = "error:${e.message}")
                })
    }
    fun loadData(news :List<New>){
        print(news)
        val adapter=NewsAdapter(this,news)
        listView.adapter=adapter
    }
}

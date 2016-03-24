package com.example.yhj.kotlindemo.api

import retrofit2.http.GET
import rx.Observable

/**
 * Created by Yi on 16/3/24.
 */
interface Api{
    @GET("/wxnew/?key=12a470643169d2734642b3bc2353cf07&num=10")
    fun getNews():Observable<DataWrapper>;
}
data class DataWrapper(val code:Int,val msg:String,val newslist:List<New>)
data class New(val ctime:String,val title:String,val description:String,val picUrl:String,val url:String)

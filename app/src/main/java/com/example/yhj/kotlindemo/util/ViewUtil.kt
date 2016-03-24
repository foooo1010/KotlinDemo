package com.example.yhj.kotlindemo.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Yi on 16/3/24.
 */
fun ImageView.loadUrl(url:String){
    Picasso.with(context).load(url).into(this)
}
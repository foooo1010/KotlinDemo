package com.example.yhj.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.yhj.kotlindemo.R
import com.example.yhj.kotlindemo.api.New
import com.example.yhj.kotlindemo.util.loadUrl
import kotlinx.android.synthetic.main.new_item.view.*

/**
 * Created by Yi on 16/3/24.
 */
class NewsAdapter(val context:Context,val data:List<New>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view=LayoutInflater.from(context).inflate(R.layout.new_item,parent,false)
        view.pic.loadUrl(data[position].picUrl)
        view.title.text=data[position].title
        view.newContent.text=data[position].description
        return view
    }

    override fun getItem(position: Int): Any? = data[position]

    override fun getItemId(position: Int)=position.toLong()

    override fun getCount()=data.size
}
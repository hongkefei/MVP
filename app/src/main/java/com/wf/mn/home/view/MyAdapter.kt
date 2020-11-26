package com.wf.mn.home.view

import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wf.mn.R

/**
 *@time : 2020-11-21-10:06
 *@author : wf
 */

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyHolder {

        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_login,parent,false))
    }

    override fun getItemCount(): Int {
        return 13;
    }

    override fun onBindViewHolder(holder: MyAdapter.MyHolder, position: Int) {




    }

    class MyHolder(item:View) : RecyclerView.ViewHolder(item)


}

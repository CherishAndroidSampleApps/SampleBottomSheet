package com.sopt.samplebottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val myDataSet: ArrayList<String>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    class ViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.my_text_view,parent,false) as TextView
        // set the view's size , margins, paddings and layout parameters
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = myDataSet[position]
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
}
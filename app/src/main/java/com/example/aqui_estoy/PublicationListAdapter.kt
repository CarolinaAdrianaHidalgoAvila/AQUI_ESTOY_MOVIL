package com.example.aqui_estoy

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PublicationListAdapter(val list: List<Publication>, recyclerViewActivity: Activity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.publication_row, parent, false)
        return PublicationListViewHolder(view)
    }

    class PublicationListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position)
        holder.itemView.findViewById<TextView>(R.id.textView_username).text = item.username
        holder.itemView.findViewById<TextView>(R.id.textView_usertag).text = item.usertag
        holder.itemView.findViewById<TextView>(R.id.textView_publication).text = item.publication
    }
}
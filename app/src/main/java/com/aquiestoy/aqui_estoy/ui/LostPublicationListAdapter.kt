package com.aquiestoy.aqui_estoy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.aquiestoy.aqui_estoy.R
import com.aquiestoy.domain.LostPublication
import com.squareup.picasso.Picasso

class LostPublicationListAdapter(val list: List<LostPublication>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.publication_row, parent, false)
        return PublicationListViewHolder(view)
    }

    class PublicationListViewHolder(view: View) : RecyclerView.ViewHolder(view)
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position)

        holder.itemView.findViewById<TextView>(R.id.textView_username).text = item.userObject.firstName + " " + item.userObject.lastName
        holder.itemView.findViewById<TextView>(R.id.textView_usertag).text = item.email
        holder.itemView.findViewById<TextView>(R.id.textView_publication).text = item.description
        if (item.userObject.photo != "") {
            Picasso.get().load(item.userObject.photo).into(holder.itemView.findViewById<ImageView>(R.id.imageView_profilePicture))
        }
        /*
        if(item.photos.isNotEmpty()) {
            val viewPager = holder.itemView.findViewById<ViewPager>(R.id.viewPager_imagesPublication)
            val viewPagerAdapter = ViewPagerAdapter(holder.itemView.context, item.photos)
            viewPager.adapter = viewPagerAdapter
        */

    }
}
package com.aquiestoy.aqui_estoy.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.aquiestoy.aqui_estoy.PostPage
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

        val username = holder.itemView.findViewById<TextView>(R.id.textView_username)
        val usertag = holder.itemView.findViewById<TextView>(R.id.textView_usertag)
        val userPublication = holder.itemView.findViewById<TextView>(R.id.textView_publication)

        username.text = item.userObject.firstName + " " + item.userObject.lastName
        usertag.text = item.email
        userPublication.text = item.description
        if (item.userObject.photo != "") {
            Picasso.get().load(item.userObject.photo).into(holder.itemView.findViewById<ImageView>(R.id.imageView_profilePicturePublication))
        }
        val viewPager = holder.itemView.findViewById<ViewPager>(R.id.viewPager_imagesPublication)
        if(item.photos.isNotEmpty()) {
            viewPager.visibility = View.VISIBLE
            val viewPagerAdapter = ViewPagerAdapter(holder.itemView.context, item.photos)
            viewPager.adapter = viewPagerAdapter
        } else {
            viewPager.visibility = View.GONE
        }

        username.setOnClickListener {
            val intent = Intent(holder.itemView.context, PostPage::class.java)
            intent.putExtra("publicationId", item.Id )
            intent.putExtra("userId", item.userId )
            startActivity(holder.itemView.context, intent, null)
        }
    }
}
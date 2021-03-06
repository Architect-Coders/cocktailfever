package com.raulcristobal.curso.kotlin.myplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MediaAdapter(val items:List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflateView =
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_media_item, parent, false)
        return ViewHolder(inflateView);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind(items[position])
    }

    override fun getItemCount(): Int =items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title=view.findViewById<TextView>(R.id.textView)
        val image=view.findViewById<ImageView>(R.id.imageView)

        fun  bind(item:MediaItem){
            title.text=item.title
        }
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
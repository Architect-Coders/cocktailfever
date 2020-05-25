package com.architect.g1.cocktailfever.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.ui.common.basicDiffUtil
import com.architect.g1.cocktailfever.ui.common.inflate
import com.architect.g1.cocktailfever.ui.common.loadUrl
import kotlinx.android.synthetic.main.view_coctel_item.view.*

private typealias CoctelListener = (Coctel) -> Unit

class CoctelAdapter (private val listener:CoctelListener) :
    RecyclerView.Adapter<CoctelAdapter.ViewHolder>(){

    var items:List<Coctel> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old,new -> old.id==new.id}
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View=parent.inflate(R.layout.view_coctel_item,false)
        return ViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount()= items.size

    class ViewHolder(view: View, private val listener: CoctelListener):
        RecyclerView.ViewHolder(view) {

        fun bind(coctelItem: Coctel){
            itemView.tv_coctail.text = coctelItem.nombre
            itemView.iv_coctail.loadUrl(coctelItem.thumbUrl)
            itemView.setOnClickListener { listener(coctelItem) }
        }
    }
}
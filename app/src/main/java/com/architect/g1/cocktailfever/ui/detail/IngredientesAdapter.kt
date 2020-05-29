package com.architect.g1.cocktailfever.ui.detail

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.domain.Ingrediente
import com.architect.g1.cocktailfever.ui.common.basicDiffUtil
import com.architect.g1.cocktailfever.ui.common.inflate
import kotlinx.android.synthetic.main.view_coctel_ingredientes_item.view.*

class IngredientesAdapter
    : RecyclerView.Adapter<IngredientesAdapter.ViewHolder>() {

    var items:List<Ingrediente> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old,new -> old.nombre==new.nombre}
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View=parent.inflate(R.layout.view_coctel_ingredientes_item,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount()= items.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(ingredienteItem: Ingrediente){
            //itemView.imagen_ingrediente.loadUrl(Ingrediente.thumbUrl)
            itemView.nombre_ingrediente.text = ingredienteItem.nombre
            itemView.cantidad_ingrediente.text=ingredienteItem.medida
        }
    }
}
package com.architect.g1.cocktailfever.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.ui.common.app
import com.architect.g1.cocktailfever.ui.common.getViewModel
import com.architect.g1.cocktailfever.ui.common.loadUrl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val COCTEL = "Detail:coctel"
    }

    private lateinit var component: DetailActivityComponent
    private val viewModel: DetailViewModel by lazy { getViewModel { component.detailViewModel } }

    private lateinit var adapter: IngredientesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        component = app.component.plus(
            DetailActivityModule(intent.getIntExtra(COCTEL,-1))
        )

        adapter= IngredientesAdapter()
        lista_ingredientes.adapter=adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: DetailViewModel.UiModel) = with(model){
        contenedorDetalle.visibility=View.VISIBLE
        tv_prepracion.text=coctel.instrucciones
        if(!model.coctel.ingredientes.isEmpty()){
            adapter.items=model.coctel.ingredientes
        }
        iv_coctail.loadUrl(model.coctel.thumbUrl)
    }
}

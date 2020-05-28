package com.architect.g1.cocktailfever.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.data.database.source.RoomDataSource
import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.data.server.CocktailDbDataSource
import com.architect.g1.cocktailfever.ui.common.app
import com.architect.g1.cocktailfever.ui.common.loadUrl
import com.architect.g1.cocktailfever.usecases.FindCoctelById
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val COCTEL = "Detail:coctel"
    }

    private lateinit var viewModel: DetailViewModel
    private lateinit var adapter: IngredientesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //TODO Esto debe ser resuelto por el inyector de dependencia
        val roomDataSource= RoomDataSource(this.app.db)
        val coctelesRepository = CoctelesRepository(roomDataSource, CocktailDbDataSource())
        val findCoctelById = FindCoctelById(coctelesRepository)

        viewModel = ViewModelProvider(
            this,
            DetailViewModelFactory(intent.getIntExtra(COCTEL,-1),findCoctelById)
        ).get()

        adapter= IngredientesAdapter()
        lista_ingredientes.adapter=adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: DetailViewModel.UiModel) = with(model){
        contenedorDetalle.visibility=View.VISIBLE
        tv_preparacion.text=model.coctel.instrucciones
        if(!model.coctel.ingredientes.isEmpty()){
            adapter.items=model.coctel.ingredientes
        }
        iv_coctail.loadUrl(model.coctel.thumbUrl)
    }
}

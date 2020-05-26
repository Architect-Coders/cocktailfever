package com.architect.g1.cocktailfever.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.architect.g1.cocktailfever.CoctelApp
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.data.database.CocktailFeverDatabase_Impl
import com.architect.g1.cocktailfever.data.database.source.RoomDataSource
import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.data.server.CocktailDbDataSource
import com.architect.g1.cocktailfever.ui.common.app
import com.architect.g1.cocktailfever.ui.common.startActivity
import com.architect.g1.cocktailfever.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.architect.g1.cocktailfever.ui.main.MainViewModel.UiModel
import com.architect.g1.cocktailfever.usecases.GetAllCocteles

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CoctelAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TODO Esto debe ser resuelto por el inyector de dependencia
        val roomDataSource=RoomDataSource(this.app.db)
        val coctelesRepository = CoctelesRepository(roomDataSource, CocktailDbDataSource())
        val getAllCocteles = GetAllCocteles(coctelesRepository)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(getAllCocteles)
        ).get()

        adapter= CoctelAdapter(viewModel::onCoctelClicked)
        recycler.adapter=adapter

        viewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(model:UiModel){

        progressBar.visibility=if(model is UiModel.Loading) View.VISIBLE else View.GONE

        when(model){
            is UiModel.Content -> adapter.items=model.cocteles
            is UiModel.Navigation -> startActivity<DetailActivity>()
        }
    }
}

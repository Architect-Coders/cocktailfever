package com.architect.g1.cocktailfever.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.di.CocktelFeverComponent
import com.architect.g1.cocktailfever.ui.common.app
import com.architect.g1.cocktailfever.ui.common.startActivity
import com.architect.g1.cocktailfever.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.architect.g1.cocktailfever.ui.main.MainViewModel.UiModel
import com.architect.g1.cocktailfever.usecases.GetAllCocteles

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CoctelAdapter

    private lateinit var component: CocktelFeverComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component = app.component
        //val roomDataSource=RoomDataSource(this.app.db)
        //val coctelesRepository = CoctelesRepository(roomDataSource, CocktailDbDataSource())
        val getAllCocteles = GetAllCocteles(component.coctelesRepository)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(getAllCocteles)
        ).get()

        adapter= CoctelAdapter(viewModel::onCoctelClicked)
        recycler.adapter=adapter

        viewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(model:UiModel){
        when(model){
            is UiModel.Content -> adapter.items=model.cocteles
            is UiModel.Navigation -> startActivity<DetailActivity>()
        }
    }
}

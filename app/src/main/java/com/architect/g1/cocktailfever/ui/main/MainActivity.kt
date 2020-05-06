package com.architect.g1.cocktailfever.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.data.FakeLocalDataSource
import com.architect.g1.cocktailfever.data.FakeRemoteDataSource
import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import kotlinx.android.synthetic.main.activity_main.*
import com.architect.g1.cocktailfever.ui.main.MainViewModel.UiModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CoctelAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(CoctelesRepository(FakeLocalDataSource(),FakeRemoteDataSource()))
        ).get()

        adapter= CoctelAdapter(viewModel::onCoctelClicked)
        recycler.adapter=adapter

        viewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(model:UiModel){
        when(model){
            is UiModel.Content -> adapter.items=model.cocteles
            is UiModel.Navigation -> TODO("Implementar Activity Datail")
        }
    }
}

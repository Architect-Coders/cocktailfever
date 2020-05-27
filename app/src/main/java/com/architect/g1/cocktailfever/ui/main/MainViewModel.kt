package com.architect.g1.cocktailfever.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.ui.common.Scope
import com.architect.g1.cocktailfever.usecases.GetAllCocteles
import kotlinx.coroutines.launch

class MainViewModel(private val getAllCoctelesUsesCase: GetAllCocteles):ViewModel(),
    Scope by Scope.Impl() {

    sealed class UiModel{
        object Loading:UiModel()
        class Content( val cocteles:List<Coctel>):UiModel()
        class Navigation(val coctel: Coctel):UiModel()
    }

    private val _model=MutableLiveData<UiModel>()
    val model:LiveData<UiModel>
        get() {
            if (_model.value==null) refresh()
            return  _model
        }

    init {
        initScope()
    }

    private  fun refresh(){
        launch {
            _model.value=UiModel.Loading
            _model.value=UiModel.Content(getAllCoctelesUsesCase.invoke())
        }
    }

    fun onCoctelClicked(coctel:Coctel){
        _model.value=UiModel.Navigation(coctel)
    }

    override fun onCleared() {
        cancelScope()
    }
}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val getAllCoctelesUsesCase: GetAllCocteles) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(getAllCoctelesUsesCase) as T
}
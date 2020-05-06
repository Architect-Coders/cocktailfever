package com.architect.g1.cocktailfever.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.ui.common.Scope
import kotlinx.coroutines.launch

class MainViewModel(private val coctelesRepository: CoctelesRepository):ViewModel(),
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
            //TODO: Pendiente a la integración rama data con el método para obtener los cocteles
            _model.value=UiModel.Content(emptyList())
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
class MainViewModelFactory(private val coctelesRepository: CoctelesRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(coctelesRepository) as T
}
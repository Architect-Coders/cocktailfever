package com.architect.g1.cocktailfever.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.ui.common.ScopeViewModel
import com.architect.g1.cocktailfever.usecases.GetAllCocteles
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllCoctelesUsesCase: GetAllCocteles,
    uiDispatcher: CoroutineDispatcher
) : ScopeViewModel(uiDispatcher) {

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val cocteles: List<Coctel>) : UiModel()
        data class Navigation(val coctel: Coctel) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    init {
        initScope()
    }

    private fun refresh() {
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getAllCoctelesUsesCase.invoke())
        }
    }

    fun onCoctelClicked(coctel: Coctel) {
        _model.value = UiModel.Navigation(coctel)
    }

    override fun onCleared() {
        cancelScope()
        super.onCleared()
    }
}

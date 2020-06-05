package com.architect.g1.cocktailfever.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.ui.common.ScopeViewModel
import com.architect.g1.cocktailfever.usecases.FindCoctelById
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class DetailViewModel(
    private val coctelId: Int,
    private val findCoctelById: FindCoctelById,
    uiDispatcher: CoroutineDispatcher): ScopeViewModel(uiDispatcher) {

    data class UiModel(val coctel: Coctel)

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) findCoctel()
            return _model
        }

    init {
        initScope()
    }

    private fun findCoctel() {
        launch {
            _model.value = UiModel(findCoctelById.invoke(coctelId))
        }
    }

    override fun onCleared() {
        super.onCleared()
        cancelScope()
    }
}

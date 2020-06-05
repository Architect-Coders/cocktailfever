package com.architect.g1.cocktailfever.ui.detail

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.usecases.FindCoctelById
import com.architect.g1.cocktailfever.usecases.GetAllCocteles
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
class DetailActivityModule(private val coctelId: Int) {

    @Provides
    fun detailViewModelProvider(findCoctelById: FindCoctelById, uiDispatcher: CoroutineDispatcher): DetailViewModel {
        return DetailViewModel(coctelId, findCoctelById, uiDispatcher)
    }

    @Provides
    fun findCoctelByIdProvider(coctelesRepository: CoctelesRepository) =
        FindCoctelById(coctelesRepository)
}

@Subcomponent(modules = [(DetailActivityModule::class)])
interface DetailActivityComponent {
    val detailViewModel: DetailViewModel
}
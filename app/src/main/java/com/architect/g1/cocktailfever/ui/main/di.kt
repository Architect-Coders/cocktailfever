package com.architect.g1.cocktailfever.ui.main

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.usecases.GetAllCocteles
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
class MainActivityModule {

    @Provides
    fun mainViewModelProvider(getAllCocteles: GetAllCocteles, uiDispatcher: CoroutineDispatcher) = MainViewModel(getAllCocteles, uiDispatcher)

    @Provides
    fun getAllCoctelesProvider(coctelesRepository: CoctelesRepository) =
        GetAllCocteles(coctelesRepository)
}

@Subcomponent(modules = [(MainActivityModule::class)])
interface MainActivityComponent {
    val mainViewModel: MainViewModel
}
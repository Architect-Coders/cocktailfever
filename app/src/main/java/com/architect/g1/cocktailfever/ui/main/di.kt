package com.architect.g1.cocktailfever.ui.main

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.usecases.GetAllCocteles
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class MainActivityModule {

    @Provides
    fun mainViewModelProvider(getAllCocteles: GetAllCocteles) = MainViewModel(getAllCocteles)

    @Provides
    fun getAllCoctelesProvider(coctelesRepository: CoctelesRepository) =
        GetAllCocteles(coctelesRepository)
}

@Subcomponent(modules = [(MainActivityModule::class)])
interface MainActivityComponent {
    val mainViewModel: MainViewModel
}
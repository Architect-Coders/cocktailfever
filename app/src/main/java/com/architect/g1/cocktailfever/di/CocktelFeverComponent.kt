package com.architect.g1.cocktailfever.di

import android.app.Application
import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.ui.main.MainActivityComponent
import com.architect.g1.cocktailfever.ui.main.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface CocktelFeverComponent {

    val coctelesRepository: CoctelesRepository

    fun plus(module: MainActivityModule): MainActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): CocktelFeverComponent
    }
}
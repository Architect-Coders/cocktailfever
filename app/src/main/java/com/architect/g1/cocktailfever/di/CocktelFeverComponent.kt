package com.architect.g1.cocktailfever.di

import android.app.Application
import com.architect.g1.cocktailfever.ui.detail.DetailActivityComponent
import com.architect.g1.cocktailfever.ui.detail.DetailActivityModule
import com.architect.g1.cocktailfever.ui.main.MainActivityComponent
import com.architect.g1.cocktailfever.ui.main.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, ServerModule::class])
interface CocktelFeverComponent {

    fun plus(module: MainActivityModule): MainActivityComponent
    fun plus(module: DetailActivityModule): DetailActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): CocktelFeverComponent
    }
}
package com.architect.g1.cocktailfever.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface CocktelFeverComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): CocktelFeverComponent
    }
}
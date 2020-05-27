package com.architect.g1.cocktailfever

import android.app.Application
import com.architect.g1.cocktailfever.di.CocktelFeverComponent
import com.architect.g1.cocktailfever.di.DaggerCocktelFeverComponent

class CoctelApp : Application() {

    lateinit var component: CocktelFeverComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerCocktelFeverComponent
            .factory()
            .create(this)
    }
}
package com.architect.g1.cocktailfever.ui

import android.app.Application
import com.architect.g1.cocktailfever.data.server.CocktailDb
import com.architect.g1.cocktailfever.di.AppModule
import com.architect.g1.cocktailfever.di.CocktelFeverComponent
import com.architect.g1.cocktailfever.di.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.mockwebserver.MockWebServer
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, TestServerModule::class])
interface UITestComponent: CocktelFeverComponent {

    val cocktailDb : CocktailDb
    val mockWebServer: MockWebServer

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): UITestComponent
    }
}

@Module
class TestServerModule {

    @Singleton
    @Provides
    @Named("baseUrl")
    fun baseUrlProvider() = "http://127.0.0.1:8080"

    @Provides
    @Singleton
    fun mockWebServerProvider(): MockWebServer {
        var mockWebServer:MockWebServer? = null
        // it is need to instantiate in background thread
        val thread = Thread(Runnable {
            mockWebServer = MockWebServer()
            mockWebServer?.start(8080)
        })
        thread.start()
        thread.join()
        return mockWebServer ?: throw NullPointerException()
    }

    /**
     * Avoid a Dagger Exception: error: [Dagger/MissingBinding]
     */
    @Provides
    @Singleton
    fun lolServiceManagerProvider(
        @Named("baseUrl") baseUrl: String
    ): CocktailDb
            = CocktailDb(baseUrl)

}
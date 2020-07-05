package com.architect.g1.cocktailfever.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.architect.g1.cocktailfever.di.*
import com.architect.g1.cocktailfever.testshared.mockedCoctel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainIntegrationTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val observer: Observer<MainViewModel.UiModel> = mock()
    private val component: TestComponent = DaggerTestComponent.factory().create()
    private lateinit var localDataSource: FakeLocalDataSource
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        mainViewModel = component.plus(MainActivityModule()).mainViewModel
        localDataSource = component.localDataSource as FakeLocalDataSource
        localDataSource.cocteles = defaultFakeCocteles
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data is loaded from server when local data source is empty`() =
        coroutinesTestRule.runBlocking {
            mainViewModel.model.observeForever(observer)

            verify(observer).onChanged(
                ArgumentMatchers.refEq(MainViewModel.UiModel.Content(defaultFakeCocteles))
            )
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `data is loaded from server when local data source has elements`() =
        coroutinesTestRule.runBlocking {
            // created to be different from defaultFakesCocteles
            val fakesLocalCocteles = listOf(mockedCoctel.copy(1))
            val localDataSource = component.localDataSource as FakeLocalDataSource
            localDataSource.cocteles = fakesLocalCocteles

            mainViewModel.model.observeForever(observer)

            verify(observer).onChanged(
                ArgumentMatchers.refEq(MainViewModel.UiModel.Content(fakesLocalCocteles))
            )
        }
}
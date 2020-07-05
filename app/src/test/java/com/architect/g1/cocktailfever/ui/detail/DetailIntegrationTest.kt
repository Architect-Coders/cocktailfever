package com.architect.g1.cocktailfever.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.architect.g1.cocktailfever.di.*
import com.architect.g1.cocktailfever.testshared.mockedCoctel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailIntegrationTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val observer: Observer<DetailViewModel.UiModel> = mock()
    private val component: TestComponent = DaggerTestComponent.factory().create()
    private lateinit var localDataSource: FakeLocalDataSource
    private lateinit var detailViewModel: DetailViewModel

    @Before
    fun setup() {
        detailViewModel = component.plus(DetailActivityModule(1)).detailViewModel
        localDataSource = component.localDataSource as FakeLocalDataSource
        localDataSource.cocteles = defaultFakeCocteles
    }

    @Test
    fun `get the coctel`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        detailViewModel.model.observeForever(observer)

        verify(observer).onChanged(
            ArgumentMatchers.refEq(DetailViewModel.UiModel(mockedCoctel.copy(1)))
        )

    }
}
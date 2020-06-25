package com.architect.g1.cocktailfever.di

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.data.source.RemoteDataSource
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.domain.Ingrediente
import com.architect.g1.cocktailfever.testshared.mockedCoctel
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


val defaultFakeCocteles = listOf(
    mockedCoctel.copy(1),
    mockedCoctel.copy(2),
    mockedCoctel.copy(3),
    mockedCoctel.copy(4)
)

@Singleton
@Component(modules = [TestAppModule::class])
interface TestComponent : CocktelFeverComponent {

    val localDataSource: LocalDataSource
    val remoteDataSource: RemoteDataSource

    @Component.Factory
    interface FactoryTest {
        fun create(): TestComponent
    }
}

@Module
class TestAppModule {

    @Provides
    @Singleton
    fun localDataSourceProvider(): LocalDataSource = FakeLocalDataSource()

    @Provides
    @Singleton
    fun remoteDataSourceProvider(): RemoteDataSource = FakeRemoteDataSource()

//    @Provides
//    @Singleton
//    fun permissionCheckerProvider(): PermissionChecker = FakePermissionChecker()

    @Provides
    fun scopeViewModel(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    @Provides
    fun coctelesRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): CoctelesRepository {
        return CoctelesRepository(localDataSource, remoteDataSource)
    }
}

class FakeLocalDataSource : LocalDataSource {

    var cocteles: List<Coctel> = emptyList()

    override suspend fun isCoctelTableEmpty() = cocteles.isEmpty()

    override suspend fun insertCoctel(coctel: Coctel) {
        var coctelesMutableList: MutableList<Coctel> = cocteles as MutableList<Coctel>
        coctelesMutableList.add(coctel)
        cocteles = coctelesMutableList
    }

    override suspend fun insertAllCocteles(cocteles: List<Coctel>) {
        this.cocteles = cocteles
    }

    override suspend fun getAllCocteles(): List<Coctel> = cocteles

    override suspend fun getCoctelById(id: Int): Coctel = cocteles.first { it.id == id }

    override suspend fun updateCoctel(coctel: Coctel) {
        cocteles = cocteles.filterNot { it.id == coctel.id } + coctel
    }

    override suspend fun deleteCoctel(coctel: Coctel) {
        var coctelesMutableList: MutableList<Coctel> = cocteles as MutableList<Coctel>
        coctelesMutableList.remove(coctel)
        cocteles = coctelesMutableList
    }

    override suspend fun deleteAllCocteles() {
        cocteles = emptyList()
    }

    override suspend fun getIngredienteById(id: Int): Ingrediente {
        TODO("Not yet implemented")
    }

    override suspend fun getAllIngredientes(): List<Ingrediente> {
        TODO("Not yet implemented")
    }

    override suspend fun isIngredienteTableEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun insertIngrediente(ingrediente: Ingrediente) {
        TODO("Not yet implemented")
    }

    override suspend fun insertAllIngredientes(ingredientes: List<Ingrediente>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateIngrediente(ingrediente: Ingrediente) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteIngrediente(ingrediente: Ingrediente) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllIngredientes() {
        TODO("Not yet implemented")
    }
}

class FakeRemoteDataSource : RemoteDataSource {

    var cocteles = defaultFakeCocteles

    override suspend fun obtenerCocteles() = cocteles
    override suspend fun obtenerDetalleCoctel(id: String): Coctel =
        cocteles.first { it.id.toString() == id }
}

//class FakePermissionChecker : PermissionChecker {
//    var permissionGranted = true
//
//    override suspend fun check(permission: PermissionChecker.Permission): Boolean =
//        permissionGranted
//}
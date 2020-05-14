package com.architect.g1.cocktailfever.data.database.source

import com.architect.g1.cocktailfever.data.aDomainCoctel
import com.architect.g1.cocktailfever.data.aDomainIngrediente
import com.architect.g1.cocktailfever.data.aRoomCoctel
import com.architect.g1.cocktailfever.data.aRoomIngrediente
import com.architect.g1.cocktailfever.data.database.CocktailFeverDatabase
import com.architect.g1.cocktailfever.data.database.dao.CoctelDao
import com.architect.g1.cocktailfever.data.database.dao.IngredienteDao
import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.domain.Ingrediente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: CocktailFeverDatabase) : LocalDataSource {

    private val coctelDao: CoctelDao = db.coctelDao()
    private val ingredienteDao: IngredienteDao = db.ingredienteDao()

    // Cóctel
    override suspend fun getCoctelById(id: Int) =
        withContext(Dispatchers.IO) { coctelDao.getById(id).aDomainCoctel() }

    override suspend fun getAllCocteles(): List<Coctel> =
        withContext(Dispatchers.IO) { coctelDao.getAll().map { it.aDomainCoctel() } }

    override suspend fun isCoctelTableEmpty(): Boolean =
        withContext(Dispatchers.IO) { coctelDao.count() == 0 }

    override suspend fun insertCoctel(coctel: Coctel) = withContext(Dispatchers.IO) {
        coctelDao.insert(coctel.aRoomCoctel())
    }

    override suspend fun insertAllCocteles(cocteles: List<Coctel>) =
        withContext(Dispatchers.IO) {
            coctelDao.insertAll(cocteles.map { it.aRoomCoctel() })
        }

    override suspend fun updateCoctel(coctel: Coctel) =
        withContext(Dispatchers.IO) {
            coctelDao.update(coctel.aRoomCoctel())
        }

    override suspend fun deleteCoctel(coctel: Coctel) =
        withContext(Dispatchers.IO) {
            coctelDao.delete(coctel.aRoomCoctel())
        }

    override suspend fun deleteAllCocteles() =
        withContext(Dispatchers.IO) {
            coctelDao.deleteAll()
        }

    // Ingrediente
    override suspend fun getIngredienteById(id: Int): Ingrediente =
        withContext(Dispatchers.IO) {
            ingredienteDao.getById(id).aDomainIngrediente()
        }

    override suspend fun getAllIngredientes(): List<Ingrediente> =
        withContext(Dispatchers.IO) {
            ingredienteDao.getAll().map { it.aDomainIngrediente() }
        }

    override suspend fun isIngredienteTableEmpty(): Boolean = withContext(Dispatchers.IO) {
        ingredienteDao.count() == 0
    }

    override suspend fun insertIngrediente(ingrediente: Ingrediente) =
        withContext(Dispatchers.IO) {
            ingredienteDao.insert(ingrediente.aRoomIngrediente())
        }

    override suspend fun insertAllIngredientes(ingredientes: List<Ingrediente>) =
        withContext(Dispatchers.IO) {
            ingredienteDao.insertAll(ingredientes.map { it.aRoomIngrediente() })
        }

    override suspend fun updateIngrediente(ingrediente: Ingrediente) =
        withContext(Dispatchers.IO) {
            ingredienteDao.update(ingrediente.aRoomIngrediente())
        }

    override suspend fun deleteIngrediente(ingrediente: Ingrediente) =
        withContext(Dispatchers.IO) {
            ingredienteDao.delete(ingrediente.aRoomIngrediente())
        }

    override suspend fun deleteAllIngredientes() = withContext(Dispatchers.IO) {
        ingredienteDao.deleteAll()
    }
}

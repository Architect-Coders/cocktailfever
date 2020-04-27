package com.architect.g1.cocktailfever.data.repository

class CoctelesRepository(val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource) {
}

interface LocalDataSource

interface RemoteDataSource
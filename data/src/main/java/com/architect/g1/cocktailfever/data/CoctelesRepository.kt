package com.architect.g1.cocktailfever.data

class CoctelesRepository(val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource) {
}

interface LocalDataSource

interface RemoteDataSource
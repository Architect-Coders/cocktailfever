package com.architect.g1.cocktailfever.data.source

interface LocalDataSource {
    fun isEmpty(): Boolean
    fun <T> findById(id: Int): T
}
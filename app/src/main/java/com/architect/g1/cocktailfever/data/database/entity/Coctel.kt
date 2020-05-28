package com.architect.g1.cocktailfever.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coctel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre:String,
    val categoria:String,
    val instrucciones:String,
    val thumbUrl:String,
    val ingredientes: List<Ingrediente>
)


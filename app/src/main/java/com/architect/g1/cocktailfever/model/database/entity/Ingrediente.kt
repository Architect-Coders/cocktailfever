package com.architect.g1.cocktailfever.model.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ingrediente (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre:String,
    val categoria:String,
    val instrucciones:String,
    val thumbUrl:String,
    val ingredientes:List<Ingrediente>
)

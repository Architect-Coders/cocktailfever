package com.architect.g1.cocktailfever.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ingrediente (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre:String,
    val medida:String
)

package com.architect.g1.cocktailfever.data.database.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {
    @TypeConverter
    fun fromIngredientesList(ingredientes: List<Ingrediente>?): String {
        if (ingredientes == null) return ""
        val gson = Gson()
        val type: Type = object : TypeToken<List<Ingrediente>>() {}.type
        return gson.toJson(ingredientes, type)
    }

    @TypeConverter
    fun toIngredientesList(ingredientes: String): List<Ingrediente> {
        if (ingredientes == "") return emptyList<Ingrediente>().toList()
        val gson = Gson()
        val type = object : TypeToken<List<Ingrediente>>() {}.type
        return gson.fromJson(ingredientes, type)
    }
}

package com.architect.g1.cocktailfever.data.database.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {
    @TypeConverter
    fun fromIngredientesList(ingredientes: MutableList<Ingrediente>?): String {
        if (ingredientes == null) return ""
        val gson = Gson()
        val type: Type = object : TypeToken<MutableList<Ingrediente>>() {}.type
        return gson.toJson(ingredientes, type)
    }

    @TypeConverter
    fun toIngredientesList(ingredientes: String): MutableList<Ingrediente> {
        if (ingredientes == "") return emptyList<Ingrediente>().toMutableList()
        val gson = Gson()
        val type = object : TypeToken<MutableList<Ingrediente>>() {}.type
        return gson.fromJson(ingredientes, type)
    }
}

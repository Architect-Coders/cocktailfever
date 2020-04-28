package com.architect.g1.cocktailfever.data.server

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResultadoCoctelDb(
    val resultados: List<Coctel>
)


@Parcelize
data class Coctel(
    @SerializedName("idDrink") val id: String,
    @SerializedName("strDrink") val nombre:String,
    @SerializedName("strDrinkThumb") val thumbUrl:String
): Parcelable

@Parcelize
data class CoctelDetalle(
@SerializedName("idDrink") val id: String,
@SerializedName("strDrink") val nombre:String,
@SerializedName("strDrinkThumb") val thumbUrl:String,
@SerializedName("strCategory") val categoria: String,
@SerializedName("strInstructions") val instrucciones: String,

@SerializedName("strIngredient1") val ingrediente_1: String,
@SerializedName("strIngredient2") val ingrediente_2: String,
@SerializedName("strIngredient3") val ingrediente_3: String,
@SerializedName("strIngredient4") val ingrediente_4: String,
@SerializedName("strIngredient5") val ingrediente_5: String,

@SerializedName("strMeasure1") val medidaIngrediente_1: String,
@SerializedName("strMeasure2") val medidaIngrediente_2: String,
@SerializedName("strMeasure3") val medidaIngrediente_3: String,
@SerializedName("strMeasure4") val medidaIngrediente_4: String,
@SerializedName("strMeasure5") val medidaIngrediente_5: String

): Parcelable
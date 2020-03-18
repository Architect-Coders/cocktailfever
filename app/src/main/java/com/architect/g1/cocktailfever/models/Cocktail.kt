package com.architect.g1.cocktailfever.models

data class Cocktail(
    val id:Int,
    val nombre:String,
    val categoria:String,
    val instrucciones:String,
    val thumbUrl:String,
    val ingredientes:List<Ingrediente>)
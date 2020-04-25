package com.architect.g1.cocktailfever.domain

data class Coctel(
    val id:Int,
    val nombre:String,
    val categoria:String,
    val instrucciones:String,
    val thumbUrl:String,
    val ingredientes:List<Ingrediente>)
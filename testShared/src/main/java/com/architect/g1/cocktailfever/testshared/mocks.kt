package com.architect.g1.cocktailfever.testshared

import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.domain.Ingrediente

val mockedIngrediente1 = Ingrediente(
  "ron",
    "1/4"
)

val mockedIngrediente2 = Ingrediente(
    "cola",
    "3/4"
)

val mockedIngrediente3 = Ingrediente(
    "lima",
    "1/4"
)

val mockedIngredienteList: List<Ingrediente> = listOf(mockedIngrediente1, mockedIngrediente2, mockedIngrediente3)

val mockedCoctel = Coctel(
    1,
    "coctel test",
    "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
    mockedIngredienteList,
    "bebida alcohólica",
    "Pon hielo en un vaso, añade el ${mockedIngrediente1.nombre}, la ${mockedIngrediente2.nombre} y ${mockedIngrediente3.nombre} y ya está listo para tomar"
)



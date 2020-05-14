package com.architect.g1.cocktailfever.data

import com.architect.g1.cocktailfever.domain.Coctel as DomainCoctel
import com.architect.g1.cocktailfever.data.database.entity.Coctel as RoomCoctel
import com.architect.g1.cocktailfever.domain.Ingrediente as DomainIngrediente
import com.architect.g1.cocktailfever.data.database.entity.Ingrediente as RoomIngrediente

fun RoomCoctel.aDomainCoctel(): DomainCoctel =
    DomainCoctel(
        id,
        nombre,
        categoria,
        instrucciones,
        thumbUrl,
        ingredientes = ArrayList<DomainIngrediente>()
    )

fun DomainCoctel.aRoomCoctel(): RoomCoctel =
    RoomCoctel(
        id,
        nombre,
        categoria,
        instrucciones,
        thumbUrl,
        ingredientes = ArrayList<RoomIngrediente>()
    )

fun RoomIngrediente.aDomainIngrediente(): DomainIngrediente =
    DomainIngrediente(
        nombre,
        medida
    )

fun DomainIngrediente.aRoomIngrediente(): RoomIngrediente =
    RoomIngrediente(
        0,
        nombre,
        medida
    )

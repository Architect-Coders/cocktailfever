package com.architect.g1.cocktailfever.data


import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.domain.CoctelLista
import com.architect.g1.cocktailfever.domain.Ingrediente
import com.architect.g1.cocktailfever.data.server.Coctel as ServerCoctel
import com.architect.g1.cocktailfever.data.server.CoctelDetalle as ServerCoctelDetalle

import com.architect.g1.cocktailfever.domain.Coctel as DomainCoctel
import com.architect.g1.cocktailfever.data.database.entity.Coctel as RoomCoctel
import com.architect.g1.cocktailfever.domain.Ingrediente as DomainIngrediente
import com.architect.g1.cocktailfever.data.database.entity.Ingrediente as RoomIngrediente


fun ServerCoctel.aDomainCoctel(): CoctelLista = CoctelLista(
    id.toInt(),
    nombre,
    thumbUrl
)
fun ServerCoctelDetalle.aDomainCoctelDetalle(): Coctel{
    val ingredientes = ArrayList<Ingrediente>()

    if(ingrediente_1.isNotEmpty())
        ingredientes.add(Ingrediente(ingrediente_1,medidaIngrediente_1))
    if(ingrediente_2.isNotEmpty())
        ingredientes.add(Ingrediente(ingrediente_2,medidaIngrediente_2))
    if(ingrediente_3.isNotEmpty())
        ingredientes.add(Ingrediente(ingrediente_3,medidaIngrediente_3))
    if(ingrediente_4.isNotEmpty())
        ingredientes.add(Ingrediente(ingrediente_4,medidaIngrediente_4))
    if(ingrediente_5.isNotEmpty())
        ingredientes.add(Ingrediente(ingrediente_5,medidaIngrediente_5))

    return Coctel(id.toInt(),nombre,categoria,instrucciones,thumbUrl,ingredientes)

}

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
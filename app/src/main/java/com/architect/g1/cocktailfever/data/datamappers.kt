package com.architect.g1.cocktailfever.data


import com.architect.g1.cocktailfever.data.server.Coctel as ServerCoctelCabecera
import com.architect.g1.cocktailfever.data.server.CoctelDetalle as ServerCoctelDetalle
import com.architect.g1.cocktailfever.domain.Coctel as DomainCoctel
import com.architect.g1.cocktailfever.data.database.entity.Coctel as RoomCoctel
import com.architect.g1.cocktailfever.domain.Ingrediente as DomainIngrediente
import com.architect.g1.cocktailfever.data.database.entity.Ingrediente as RoomIngrediente


fun ServerCoctelCabecera.aDomainCoctel(): DomainCoctel = DomainCoctel(
    id.toInt(),
    nombre,
    thumbUrl
)
fun ServerCoctelDetalle.aDomainCoctelDetalle(): DomainCoctel{
    val ingredientes = ArrayList<DomainIngrediente>()

    if(ingrediente_1 != null && medidaIngrediente_1 != null)
        ingredientes.add(DomainIngrediente(ingrediente_1,medidaIngrediente_1))
    if(ingrediente_2 != null && medidaIngrediente_2 != null)
        ingredientes.add(DomainIngrediente(ingrediente_2,medidaIngrediente_2))
    if(ingrediente_3 != null && medidaIngrediente_3 != null)
        ingredientes.add(DomainIngrediente(ingrediente_3,medidaIngrediente_3))
    if(ingrediente_4 != null && medidaIngrediente_4 != null)
        ingredientes.add(DomainIngrediente(ingrediente_4,medidaIngrediente_4))
    if(ingrediente_5 != null && medidaIngrediente_5 != null)
        ingredientes.add(DomainIngrediente(ingrediente_5,medidaIngrediente_5))

    return DomainCoctel(id.toInt(),nombre,thumbUrl,ingredientes,categoria,instrucciones)

}

fun RoomCoctel.aDomainCoctel(): DomainCoctel =
    DomainCoctel(
        id,
        nombre,
        thumbUrl,
        ArrayList<DomainIngrediente>(),
        categoria,
        instrucciones
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

package com.architect.g1.cocktailfever.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.data.database.source.RoomDataSource
import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.domain.Ingrediente
import com.architect.g1.cocktailfever.ui.common.app
import com.architect.g1.cocktailfever.usecases.FindByIdCoctelPruebaRoom
import com.architect.g1.cocktailfever.usecases.InsertCoctelPruebaRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testViewPrueba: TextView = findViewById(R.id.textViewPrueba)
        testViewPrueba.text = probarRoom()
    }

    private fun probarRoom(): String {
        val ingredientes: MutableList<Ingrediente> = ArrayList();
        ingredientes.add(Ingrediente("Ginebra", "4ml"))
        ingredientes.add(Ingrediente("Tónica", "20ml"))
        var coctel = Coctel(
            1,
            "Prueba Cocktel",
            "Categoría",
            "Poner muuucho hielo",
            "https://image.tmdb.org/t/p/w500/5BwqwxMEjeFtdknRV792Svo0K1v.jpg",
            ingredientes
        )

        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val ds = RoomDataSource(app.db)
                val repo = CoctelesRepository(ds)
                InsertCoctelPruebaRoom(repo).invoke(coctel)
                val coctel1 = FindByIdCoctelPruebaRoom(repo).invoke(1)
                Log.d("TAG1", coctel1.nombre) }
        }

        return coctel.nombre
    }
}

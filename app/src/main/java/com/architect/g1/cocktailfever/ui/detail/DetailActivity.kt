package com.architect.g1.cocktailfever.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.architect.g1.cocktailfever.R

class DetailActivity : AppCompatActivity() {

    companion object {
        const val COCTEL = "Detail:coctel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Toast.makeText(
            this,
            intent.getIntExtra(COCTEL,-1).toString(),
            Toast.LENGTH_LONG).show()
    }
}

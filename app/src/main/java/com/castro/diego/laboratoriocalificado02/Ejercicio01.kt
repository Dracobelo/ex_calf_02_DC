package com.castro.diego.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Ejercicio01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01)

        // Referencias UI
        val greenView: View = findViewById(R.id.green_view)
        val btnMostrar: Button = findViewById(R.id.btn_mostrar)
        val btnOcultar: Button = findViewById(R.id.btn_ocultar)

        // Mostrar el View
        btnMostrar.setOnClickListener {
            greenView.visibility = View.VISIBLE
        }

        // Ocultar el View
        btnOcultar.setOnClickListener {
            greenView.visibility = View.INVISIBLE
        }
    }
}
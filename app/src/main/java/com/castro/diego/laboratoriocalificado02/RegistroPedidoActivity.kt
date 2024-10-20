package com.castro.diego.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistroPedidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pedido)

        val nombreCliente = findViewById<EditText>(R.id.nombre_cliente)
        val numeroCliente = findViewById<EditText>(R.id.numero_cliente)
        val productos = findViewById<EditText>(R.id.productos)
        val direccion = findViewById<EditText>(R.id.direccion)
        val ciudad = findViewById<EditText>(R.id.ciudad)
        val btnRegistrar = findViewById<Button>(R.id.btn_registrar)

        btnRegistrar.setOnClickListener {
            if (nombreCliente.text.toString().trim().isEmpty() ||
                numeroCliente.text.toString().trim().isEmpty() ||
                productos.text.toString().trim().isEmpty() ||
                direccion.text.toString().trim().isEmpty() ||
                ciudad.text.toString().trim().isEmpty()) {

                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val direccionCiudad = "${direccion.text.toString().trim()}, ${ciudad.text.toString().trim()}"

                val intent = Intent(this, DetallePedidoActivity::class.java)
                intent.putExtra("nombreCliente", nombreCliente.text.toString().trim())
                intent.putExtra("numeroCliente", numeroCliente.text.toString().trim())
                intent.putExtra("productos", productos.text.toString().trim())
                intent.putExtra("direccionCiudad", direccionCiudad)
                startActivity(intent)
            }
        }


    }
}

package com.castro.diego.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetallePedidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)

        val nombreCliente = intent.getStringExtra("nombreCliente")
        val numeroCliente = intent.getStringExtra("numeroCliente")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccionCiudad")

        // Asignar los datos a las vistas
        findViewById<TextView>(R.id.tv_nombre_cliente).text = nombreCliente
        findViewById<TextView>(R.id.tv_numero_cliente).text = numeroCliente
        findViewById<TextView>(R.id.tv_producto).text = productos
        findViewById<TextView>(R.id.tv_ubicacion).text = direccion


        findViewById<ImageButton>(R.id.btn_llamar).setOnClickListener {
            val intentLlamar = Intent(Intent.ACTION_DIAL)
            intentLlamar.data = Uri.parse("tel:$numeroCliente")
            startActivity(intentLlamar)
        }

        findViewById<ImageButton>(R.id.btn_whatsapp).setOnClickListener {
            val mensaje = "Hola $nombreCliente, tu producto: $productos ya está en camino a la dirección: $direccion"
            val numeroClienteFormatted =
                numeroCliente?.replace(" ", "")?.replace("-", "") // Formateador el número


            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/$numeroClienteFormatted?text=${Uri.encode(mensaje)}")


            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
            }
        }


        findViewById<ImageButton>(R.id.btn_google_maps).setOnClickListener {
            if (!direccion.isNullOrEmpty()) {
                val intentMaps = Intent(Intent.ACTION_VIEW)
                val gmmIntentUri = Uri.parse("geo:0,0?q=$direccion")
                intentMaps.data = gmmIntentUri
                intentMaps.setPackage("com.google.android.apps.maps")

                try {
                    startActivity(intentMaps)
                } catch (e: Exception) {
                    Toast.makeText(this, "Google Maps no está instalado", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Dirección no disponible", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

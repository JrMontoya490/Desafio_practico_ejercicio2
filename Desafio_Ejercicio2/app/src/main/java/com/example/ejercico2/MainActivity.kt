package com.example.ejercico2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.time.times

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCalcular: Button = findViewById(R.id.btnCalcular)
        botonCalcular.setOnClickListener { realizarCalculo() }

    }

    private fun realizarCalculo() {
        val campoNombre: EditText = findViewById(R.id.idNombre)
        val campoSueldo: EditText = findViewById(R.id.idSueldo)
        val mensajeAfp: TextView = findViewById(R.id.txtAfp)
        val mensajeIsss: TextView = findViewById(R.id.txtIsss)
        val mensajeRenta: TextView = findViewById(R.id.txtRenta)
        val mensajeNeto: TextView = findViewById(R.id.txtNeto)

        val nombre: String = campoNombre.text.toString()
        val sueldo: Double = campoSueldo.text.toString().toDouble()

        val afp = sueldo * 0.0725
        val isss = sueldo * 0.03
        val renta: Double = when {
            sueldo <= 472.00 -> 0.0
            sueldo in 472.01..895.24 -> sueldo * 0.10
            sueldo in 895.25..2038.10 -> sueldo * 0.20
            sueldo >= 2038.11 -> sueldo * 0.30
            else -> 0.0
        }

        val neto = sueldo - afp - isss - renta

        mensajeAfp.text = "AFP:$$afp"
        mensajeIsss.text = "ISSS:$$isss"
        mensajeRenta.text = "Renta:$$renta"
        mensajeNeto.text = "Sueldo Neto:$$neto"
    }
}

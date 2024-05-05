package com.example.pc01_alvarez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etParcial: EditText = findViewById(R.id.etParcial)
        val etFinal: EditText = findViewById(R.id.etFinal)
        val etPep: EditText = findViewById(R.id.etPep)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            val pesoParcial = 0.2f
            val pesoFinal = 0.2f
            val pesoPep = 0.6f

            val promedio = ((etParcial.text.toString().toFloat() * pesoParcial) +
                    (etFinal.text.toString().toFloat() * pesoFinal) +
                    (etPep.text.toString().toFloat() * pesoPep)).toString()

            sendPromedio(promedio)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun sendPromedio(promedio: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("prom", promedio)
        startActivity(intent)
    }
}
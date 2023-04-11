package com.example.aqui_estoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class portada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portada)

        val btnIrARegistrarse = findViewById<Button>(R.id.registrarse)
        val btnIrAIngresar = findViewById<Button>(R.id.ingresar)

        btnIrARegistrarse.setOnClickListener{
            val ventanaRegistrarse: Intent = Intent(applicationContext, Signin::class.java)
            startActivity(ventanaRegistrarse)
        }

        btnIrAIngresar.setOnClickListener{
            val ventanaIngresar: Intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(ventanaIngresar)
        }

    }

}
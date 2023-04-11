package com.example.aqui_estoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val btnIrAIngresar = findViewById<Button>(R.id.button_login)

        btnIrAIngresar.setOnClickListener{
            val Home: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(Home)
        }
    }

}
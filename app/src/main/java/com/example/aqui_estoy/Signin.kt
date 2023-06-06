package com.example.aqui_estoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aqui_estoy.ui.MainActivity

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val btnIrARegistrarse = findViewById<Button>(R.id.button_signin)
        btnIrARegistrarse.setOnClickListener{
            val Home: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(Home)
        }
    }
}
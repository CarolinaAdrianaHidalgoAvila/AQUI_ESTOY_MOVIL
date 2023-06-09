package com.aquiestoy.aqui_estoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aquiestoy.aqui_estoy.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var ingresar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.editText_email)
        editTextPassword = findViewById(R.id.editText_password)
        ingresar = findViewById(R.id.button_login)

        ingresar.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Inicio de sesión exitoso, el usuario ha iniciado sesión
                        val user = FirebaseAuth.getInstance().currentUser

                        // Redirige al usuario a la actividad principal
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        // Error en el inicio de sesión
                        Toast.makeText(this, "Error en el inicio de sesión.", Toast.LENGTH_SHORT).show()
                    }
                }

        }
        }

    }

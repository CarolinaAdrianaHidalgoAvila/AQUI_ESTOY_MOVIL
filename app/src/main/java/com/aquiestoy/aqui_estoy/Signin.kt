package com.aquiestoy.aqui_estoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.aquiestoy.aqui_estoy.ui.MainActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Signin : AppCompatActivity() {
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var registrarse: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        FirebaseApp.initializeApp(this)

        editTextEmail = findViewById(R.id.siginText_email)
        editTextPassword = findViewById(R.id.siginText_password)
        registrarse = findViewById(R.id.button_signin)


        registrarse.setOnClickListener{
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Registro exitoso, el usuario se ha creado
                        val user = FirebaseAuth.getInstance().currentUser
                        // Puedes realizar acciones adicionales, como enviar un correo de verificación

                        // Redirige al usuario a la actividad de inicio de sesión
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else {
                        // Error en el registro
                        Toast.makeText(this, "Error en el registro de usuario.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
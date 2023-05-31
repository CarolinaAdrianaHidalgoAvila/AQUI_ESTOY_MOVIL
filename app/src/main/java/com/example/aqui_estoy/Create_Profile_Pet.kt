package com.example.aqui_estoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Create_Profile_Pet : AppCompatActivity() {
    lateinit var namePet: EditText
    lateinit var btnPub : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile_pet)
        btnPub = findViewById(R.id.btnPublish)
        namePet = findViewById(R.id.namePet)
//        namePet = findViewById(R.id.namePet)


        btnPub.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val retrofitAdapter = RestApiAdapter()
                val newPet = Pet(
                    "2131243",
                    namePet.text.toString(),
                    "2131243",
                    "2131243",
                    "2131243",
                    "2131243",
                    "2131243",
                )
                val petCreated = retrofitAdapter.connectionApi().registerPet("632333ceca137c2c4b95168c", newPet)
                //contruir retrofit llamar metodo
            }
        }
    }
}
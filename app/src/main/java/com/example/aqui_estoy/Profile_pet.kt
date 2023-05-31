package com.example.aqui_estoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

class Profile_pet : AppCompatActivity() {
    private lateinit var profileViewModel: ProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_pet)

        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        // Observar cambios en petLiveData
        profileViewModel.petLiveData.observe(this, Observer { pet ->
            // Actualizar la vista con los datos de la mascota
            val tvNamePet: TextView = findViewById(R.id.tvNamePet)
            tvNamePet.text = pet.namePet
        })

        // Cargar los datos de la mascota
        profileViewModel.loadPet()
    }
}
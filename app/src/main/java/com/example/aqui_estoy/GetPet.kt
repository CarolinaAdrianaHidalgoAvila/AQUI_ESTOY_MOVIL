package com.example.aqui_estoy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.domain.Pet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import com.example.aqui_estoy.RestApiAdapterPet as RestApiAdapterPet


class GetPet : AppCompatActivity() {

    private lateinit var viewModel: GetPetViewModel
    private lateinit var tvNombre: TextView
    private lateinit var tvFechaNacimiento: TextView
    private lateinit var tvGenero: TextView
    private lateinit var tvCollar: TextView
    private lateinit var tvEspecie: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_pet)

        viewModel = ViewModelProvider(this).get(GetPetViewModel::class.java)

        tvNombre = findViewById(R.id.tv_name_pet)
        tvFechaNacimiento = findViewById(R.id.tv_fecha_nacimiento)
        tvGenero = findViewById(R.id.tv_genero)
        tvCollar = findViewById(R.id.tv_collar)
        tvEspecie = findViewById(R.id.tv_especie)

        val idUser = "632333ceca137c2c4b95168c"
        val idPet = "635716a5a2059dbd379482bb"

        viewModel.pet.observe(this, { pet ->
            pet?.let {
                actualizarInterfazUsuario(it)
            }
        })

        viewModel.fetchPet(idUser, idPet)
    }

    private fun actualizarInterfazUsuario(pet: Pet) {
        tvNombre.text = pet.namePet
        tvFechaNacimiento.text = formatDate(pet.birthDate)
        tvGenero.text = getGenderLabel(pet.gender)
        tvCollar.text = getYesNoLabel(pet.hasNecklace)
        tvEspecie.text = pet.specie
    }

    private fun formatDate(date: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val parsedDate = dateFormat.parse(date)
        val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return formattedDate.format(parsedDate)
    }

    private fun getGenderLabel(gender: String): String {
        return if (gender == "M") "Macho" else "Hembra"
    }

    private fun getYesNoLabel(hasNecklace: Boolean): String {
        return if (hasNecklace) "Sí" else "No"
    }
}

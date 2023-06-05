package com.example.aqui_estoy

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.Pet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import com.example.aqui_estoy.RestApiAdapterPet as RestApiAdapterPet


class GetPet : AppCompatActivity() {

    lateinit var tvNombre: TextView
    lateinit var tvFechaNacimiento: TextView
    lateinit var tvGenero: TextView
    lateinit var tvCollar: TextView
    lateinit var tvEspecie: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_pet)

        tvNombre = findViewById(R.id.tv_name_pet)
        tvFechaNacimiento = findViewById(R.id.tv_fecha_nacimiento)
        tvGenero = findViewById(R.id.tv_genero)
        tvCollar = findViewById(R.id.tv_collar)
        tvEspecie = findViewById(R.id.tv_especie)

        val idUser = "632333ceca137c2c4b95168c"
        val idPet = "635716a5a2059dbd379482bb"

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val pet = getPetFromApi(idUser, idPet)
                actualizarInterfazUsuario(pet)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun getPetFromApi(idUser: String, idPet: String): Pet {
        val restApiAdapter = RestApiAdapterPet()
        val endPoint = restApiAdapter.connectionApi()
        return withContext(Dispatchers.IO) {
            endPoint.getPet(idUser, idPet)
        }
    }

    private fun actualizarInterfazUsuario(pet: Pet) {
        runOnUiThread {
            tvNombre.text = pet.namePet
            tvFechaNacimiento.text = formatDate(pet.birthDate)
            tvGenero.text = getGenderLabel(pet.gender)
            tvCollar.text = getYesNoLabel(pet.hasNecklace)
            tvEspecie.text = pet.specie
        }
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

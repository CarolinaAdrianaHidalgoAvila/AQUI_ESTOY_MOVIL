package com.example.aqui_estoy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PetFormViewModel : ViewModel() {
    val registrationStatus = MutableLiveData<Boolean>()

    fun registerPet(pet: Pet) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    // Realizar la llamada a la API para registrar los datos de la mascota
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://aquiestoymongodb.azurewebsites.net/api/users/632333ceca137c2c4b95168c/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val apiService = retrofit.create(PetApiService::class.java)
                    val response = apiService.registerPet(pet)

                    // Retorna la respuesta de la API
                    response
                }

                // Verificar el código de respuesta y establecer el estado de registro en función de ello
                if (response.code() == 200) {
                    // La llamada fue exitosa
                    registrationStatus.value = true
                } else {
                    // La llamada no fue exitosa
                    registrationStatus.value = false
                }
            } catch (e: Exception) {
                // Manejar cualquier error o excepción ocurrida durante la llamada a la API
                // Puedes mostrar un mensaje de error o realizar otras acciones según sea necesario
                registrationStatus.value = false
            }
        }
    }

}


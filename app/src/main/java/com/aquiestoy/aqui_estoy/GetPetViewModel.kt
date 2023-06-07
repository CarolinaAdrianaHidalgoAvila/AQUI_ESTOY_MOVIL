package com.aquiestoy.aqui_estoy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aquiestoy.domain.Pet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetPetViewModel : ViewModel() {

    private val _pet = MutableLiveData<Pet>()
    val pet: LiveData<Pet> get() = _pet

    fun fetchPet(idUser: String, idPet: String) {
        viewModelScope.launch {
            try {
                val pet = getPetFromApi(idUser, idPet)
                _pet.value = pet
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
}

package com.example.aqui_estoy
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ProfileViewModel : ViewModel() {
    private val petRepository = PetRepository()

    val petLiveData: MutableLiveData<Pet> = MutableLiveData()

    fun loadPet() {
        GlobalScope.launch(Dispatchers.IO) {
            val pet = petRepository.getPet()
            petLiveData.postValue(pet)
        }
    }
}
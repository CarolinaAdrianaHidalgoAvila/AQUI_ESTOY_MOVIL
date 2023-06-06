package com.example.aqui_estoy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetUserViewModel: ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun fetchUser(idUser: String) {
        viewModelScope.launch {
            try {
                val user = getUserFromApi(idUser)
                _user.value = user
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun getUserFromApi(idUser: String): User {
        val restApiAdapter = RestApiAdapterUser()
        val endPoint = restApiAdapter.connectionApi()
        return withContext(Dispatchers.IO) {
            endPoint.getUser(idUser)
        }
    }
}
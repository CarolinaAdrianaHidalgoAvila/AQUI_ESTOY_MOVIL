package com.aquiestoy.aqui_estoy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.aquiestoy.domain.Publication

class GetPublicationViewModel: ViewModel() {
    private val _publication = MutableLiveData<Publication>()
    val publication: LiveData<Publication> get() = _publication

    fun fetchPublication(idUser: String, idPublication: String) {
        viewModelScope.launch {
            try {
                val publication = getPublicationFromApi(idUser, idPublication)
                _publication.value = publication
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private suspend fun getPublicationFromApi(idUser: String, idPublication: String): Publication {
        val restApiAdapter = RestApiAdapterPublication()
        val endPoint = restApiAdapter.connectionApi()
        return withContext(Dispatchers.IO) {
            endPoint.getPublication(idUser, idPublication)
        }
    }
}
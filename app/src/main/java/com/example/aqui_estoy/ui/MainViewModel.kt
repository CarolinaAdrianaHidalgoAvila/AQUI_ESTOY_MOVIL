package com.example.aqui_estoy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.LostPublication
import com.example.usercase.GetAllLostPublications
import com.example.usercase.GetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val lostPublications: GetAllLostPublications, private val user: GetUser): ViewModel() {
    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() = _model

    sealed class UiModel() {
        class Content(val lostPublications: List<LostPublication>) : UiModel()
        class Loading(): UiModel()
    }
    fun loadPublications() {
        CoroutineScope(Dispatchers.IO).launch {
            var publications = lostPublications.invoke()
            publications.forEach {
                it.userObject = user.invoke(it.userId)
            }
            _model.postValue(UiModel.Content(publications))
        }
    }

}
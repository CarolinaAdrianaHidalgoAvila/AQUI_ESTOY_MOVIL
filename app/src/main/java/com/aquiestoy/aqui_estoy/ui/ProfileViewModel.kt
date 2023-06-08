package com.aquiestoy.aqui_estoy.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aquiestoy.domain.LostPublication
import com.aquiestoy.domain.User
import com.aquiestoy.usercase.GetAllLostPublications
import com.aquiestoy.usercase.GetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val user: GetUser): ViewModel() {
    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() = _model

    sealed class UiModel() {
        class Content(val user: User) : UiModel()
        class Loading(): UiModel()
    }

    fun loadUser(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            var user = user.invoke(id)
            _model.postValue(UiModel.Content(user))
        }
    }

}
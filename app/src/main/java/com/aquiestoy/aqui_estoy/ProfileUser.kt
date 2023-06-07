package com.aquiestoy.aqui_estoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.aquiestoy.domain.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import com.aquiestoy.aqui_estoy.RestApiAdapterUser as RestApiAdapterUser

class ProfileUser : AppCompatActivity() {
    private lateinit var viewModel: GetUserViewModel
    private lateinit var tvFirstName: TextView
    private lateinit var tvLastName: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvAddress: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_user)

        viewModel = ViewModelProvider(this).get(GetUserViewModel::class.java)

        tvFirstName = findViewById(R.id.tv_FirstName)
        tvLastName = findViewById(R.id.tv_LastName)
        tvPhone= findViewById(R.id.tv_Phone)
        tvEmail= findViewById(R.id.tv_Email)
        tvAddress= findViewById(R.id.tv_Address)
        val idUser = "632333ceca137c2c4b95168c"

        viewModel.user.observe(this, { user ->
            user?.let {
                actualizarInterfazUsuario(it)
            }
        })

        viewModel.fetchUser(idUser)
    }
    private fun actualizarInterfazUsuario(user: User) {
        runOnUiThread {
            tvFirstName.text = user.firstName
            tvLastName.text = user.lastName
            tvPhone.text = user.phone
            tvEmail.text = user.email
            tvAddress.text = user.address
        }
    }
}
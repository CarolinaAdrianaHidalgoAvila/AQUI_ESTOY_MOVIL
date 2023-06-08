package com.aquiestoy.aqui_estoy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aquiestoy.aqui_estoy.GetUserViewModel
import com.aquiestoy.aqui_estoy.R
import com.aquiestoy.domain.User
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var viewModel: GetUserViewModel
    private lateinit var tvFirstName: TextView
    private lateinit var tvLastName: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvAddress: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        viewModel = ViewModelProvider(this).get(GetUserViewModel::class.java)

        tvFirstName = view.findViewById(R.id.tv_FirstName)
        tvLastName = view.findViewById(R.id.tv_LastName)
        tvPhone= view.findViewById(R.id.tv_Phone)
        tvEmail= view.findViewById(R.id.tv_Email)
        tvAddress= view.findViewById(R.id.tv_Address)
        val idUser = "632333ceca137c2c4b95168c"

        viewModel.user.observe(viewLifecycleOwner, { user ->
            user?.let {
                actualizarInterfazUsuario(it)
            }
        })

        viewModel.fetchUser(idUser)
        return view
    }
    private fun actualizarInterfazUsuario(user: User) {
        requireActivity().runOnUiThread {
            tvFirstName.text = user.firstName
            tvLastName.text = user.lastName
            tvPhone.text = user.phone
            tvEmail.text = user.email
            tvAddress.text = user.address
        }
    }
}
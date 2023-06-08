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
import com.aquiestoy.aqui_estoy.R
import com.aquiestoy.domain.User
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    lateinit var profilePictureImageView: ImageView
    lateinit var usernameTextView: TextView
    lateinit var usertagTextView: TextView

    private val profileViewModel: ProfileViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        profilePictureImageView = view.findViewById(R.id.imageView_pictureProfile)
        usernameTextView = view.findViewById(R.id.textView_usernameProfile)
        usertagTextView = view.findViewById(R.id.textView_usertagProfile)

        profileViewModel.model.observe(viewLifecycleOwner, Observer (::updateUi))

        profileViewModel.loadUser("632333ceca137c2c4b95168c")
        return view
    }

    private fun updateUi(uiModel: ProfileViewModel.UiModel?) {
        when(uiModel) {
            is ProfileViewModel.UiModel.Content -> showUser(uiModel.user)
            else -> Toast.makeText(context, "AS", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showUser(user: User) {
        if(user.photo != ""){
            Picasso.get().load(user.photo).into(profilePictureImageView)
        }
        usernameTextView.text = user.firstName + " " + user.lastName
        usertagTextView.text = user.email
    }
}
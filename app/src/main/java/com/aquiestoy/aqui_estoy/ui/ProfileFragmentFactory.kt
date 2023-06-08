package com.aquiestoy.aqui_estoy.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

class ProfileFragmentFactory
@Inject
constructor(): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ProfileFragment:: class.java.name -> {
                ProfileFragment()
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}
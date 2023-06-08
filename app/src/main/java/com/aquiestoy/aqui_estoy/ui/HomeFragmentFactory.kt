package com.aquiestoy.aqui_estoy.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

class HomeFragmentFactory
    @Inject
    constructor(): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            HomeFragment:: class.java.name -> {
                HomeFragment()
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}
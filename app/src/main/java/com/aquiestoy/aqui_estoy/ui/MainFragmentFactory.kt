package com.aquiestoy.aqui_estoy.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

class MainFragmentFactory
    @Inject
    constructor(): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            HomeFragment:: class.java.name -> {
                HomeFragment()
            }
            // En caso de implementar mas fragmentos agregarlos aqui como se indica
            LocationFragment::class.java.name -> {
                LocationFragment()
            }
            NotificationsFragment::class.java.name -> {
                NotificationsFragment()
            }
            ProfileFragment::class.java.name -> {
                ProfileFragment()
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}
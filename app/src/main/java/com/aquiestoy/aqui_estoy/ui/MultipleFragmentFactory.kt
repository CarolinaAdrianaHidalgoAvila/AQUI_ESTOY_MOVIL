package com.aquiestoy.aqui_estoy.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

class MultipleFragmentFactory @Inject constructor(
    private val homeFragmentFactory: HomeFragmentFactory,
    private val profileFragmentFactory: ProfileFragmentFactory,
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            HomeFragment::class.java.name -> homeFragmentFactory.instantiate(classLoader, className)
            ProfileFragment::class.java.name -> profileFragmentFactory.instantiate(classLoader, className)
            // Agrega más casos aquí para cada FragmentFactory adicional
            else -> super.instantiate(classLoader, className)
        }
    }
}
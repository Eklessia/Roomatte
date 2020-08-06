package cl.malditosnakamas.persistenciadedatos.main

import androidx.fragment.app.FragmentManager
import cl.malditosnakamas.persistenciadedatos.R
import cl.malditosnakamas.persistenciadedatos.bienvenida.BienvenidaFragment
import cl.malditosnakamas.persistenciadedatos.home.HomeFragment
import javax.inject.Inject

class MainNavigator @Inject constructor() {

    fun goToBienvenida(fragmentManager: FragmentManager) {
        val fragment =
            BienvenidaFragment()
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment).commit()
    }

    fun goToHome(fragmentManager: FragmentManager) {
        val homeFragment =
            HomeFragment()
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, homeFragment).commit()
    }
}
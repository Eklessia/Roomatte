package cl.malditosnakamas.persistenciadedatos.main

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import cl.malditosnakamas.persistenciadedatos.R


class MainFragment : Fragment(R.layout.fragment_main) {

    private val mainPreferences = MainPreferences()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (mainPreferences.isFirstOpenApp(requireContext())) {
            Toast.makeText(requireContext(), "Es first open", Toast.LENGTH_SHORT).show()
            mainPreferences.saveOpenApplication(requireContext())
        }
    }
}
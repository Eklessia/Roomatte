package cl.malditosnakamas.persistenciadedatos.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import cl.malditosnakamas.persistenciadedatos.R
import cl.malditosnakamas.persistenciadedatos.databinding.FragmentHomeBinding
import cl.malditosnakamas.persistenciadedatos.personajes.presentation.PersonajesFragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.let { safeView ->
            binding = FragmentHomeBinding.bind(safeView)
            setupButton()
        }
    }

    private fun setupButton() {
        binding.btnIrA.setOnClickListener {
            val personajesFragment =
                PersonajesFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, personajesFragment)?.addToBackStack(null)
                ?.commit()
        }
    }
}

package cl.malditosnakamas.persistenciadedatos.bienvenida

import android.os.Bundle
import androidx.fragment.app.Fragment
import cl.malditosnakamas.persistenciadedatos.R
import cl.malditosnakamas.persistenciadedatos.databinding.FragmentBienvenidaBinding

class BienvenidaFragment : Fragment(R.layout.fragment_bienvenida){

    private lateinit var binding: FragmentBienvenidaBinding
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.let { safeView ->
            binding = FragmentBienvenidaBinding.bind(safeView)
            setupClickListener()
        }
    }

    private fun setupClickListener() {

    }

}

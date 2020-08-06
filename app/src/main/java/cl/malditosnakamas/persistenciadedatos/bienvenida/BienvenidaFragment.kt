package cl.malditosnakamas.persistenciadedatos.bienvenida

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import cl.malditosnakamas.persistenciadedatos.R
import cl.malditosnakamas.persistenciadedatos.databinding.FragmentBienvenidaBinding
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.LocalPersonajesRepository
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper.PersonajeMapper
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper.PersonajesMapper
import cl.malditosnakamas.persistenciadedatos.personajes.domain.PersonajesRepository
import cl.malditosnakamas.persistenciadedatos.personajes.domain.SavePersonajesUseCase
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personaje
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BienvenidaFragment : Fragment(R.layout.fragment_bienvenida) {

    lateinit var savePersonajesUseCase: SavePersonajesUseCase
    lateinit var repository: PersonajesRepository
    lateinit var personajesMapper: PersonajesMapper
    lateinit var personajeMapper: PersonajeMapper

    private lateinit var binding: FragmentBienvenidaBinding

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBienvenidaBinding.bind(view)
        setupClickListener()
        setupDependencies()
        savePersonajesUseCase
            .excecute(Personaje(1,"Harttyn", "https://url.jpg"))

    }

    private fun handleError(error: Throwable?) {
        Toast.makeText(requireContext(), "Result ${error?.message}", Toast.LENGTH_SHORT).show()
    }

    private fun handleResult(result: Long?) {
        Toast.makeText(requireContext(), "Result $result", Toast.LENGTH_SHORT).show()
    }

    private fun setupDependencies() {
        personajeMapper = PersonajeMapper()
        personajesMapper = PersonajesMapper(personajeMapper)
        repository = LocalPersonajesRepository(requireContext(), personajesMapper)
        savePersonajesUseCase = SavePersonajesUseCase(repository)
    }

    private fun setupClickListener() {

    }

}

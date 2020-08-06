package cl.malditosnakamas.persistenciadedatos.personajes.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import cl.malditosnakamas.persistenciadedatos.R
import cl.malditosnakamas.persistenciadedatos.databinding.FragmentPersonajesBinding
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.LocalPersonajesRepository
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper.PersonajeMapper
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper.PersonajesMapper
import cl.malditosnakamas.persistenciadedatos.personajes.domain.ObtenerPersonajesUseCase
import cl.malditosnakamas.persistenciadedatos.personajes.domain.PersonajesRepository
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personajes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PersonajesFragment : Fragment(R.layout.fragment_personajes) {

    lateinit var binding: FragmentPersonajesBinding
    lateinit var obtenerPersonajesUseCase: ObtenerPersonajesUseCase
    lateinit var repository: PersonajesRepository
    lateinit var mapperPersonajes: PersonajesMapper
    lateinit var mapperPersonaje: PersonajeMapper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPersonajesBinding.bind(view)
        setupDependencies()
        callObtenerPersonajesUseCase()
    }

    @SuppressLint("CheckResult")
    private fun callObtenerPersonajesUseCase() {
        obtenerPersonajesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                handleResult(result)
            }, { error ->
                handleError(error)
            })
    }

    private fun handleError(error: Throwable?) {
        Toast.makeText(requireContext(), "Error ${error?.message}", Toast.LENGTH_SHORT).show()
    }

    private fun handleResult(result: Personajes?) {
        Toast.makeText(requireContext(), "Result ${result?.list}", Toast.LENGTH_SHORT).show()
    }

    private fun setupDependencies() {
        mapperPersonaje = PersonajeMapper()
        mapperPersonajes = PersonajesMapper(mapperPersonaje)
        repository = LocalPersonajesRepository(requireContext(), mapperPersonajes)
        obtenerPersonajesUseCase = ObtenerPersonajesUseCase(repository)
    }
}
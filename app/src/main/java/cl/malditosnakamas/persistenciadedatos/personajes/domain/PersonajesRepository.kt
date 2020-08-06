package cl.malditosnakamas.persistenciadedatos.personajes.domain

import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personaje
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personajes
import io.reactivex.Single

interface PersonajesRepository {
    fun getAll() : Single<Personajes>
    fun save(personaje: Personaje)
}
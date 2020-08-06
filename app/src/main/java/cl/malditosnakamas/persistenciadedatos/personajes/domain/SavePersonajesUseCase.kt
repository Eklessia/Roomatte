package cl.malditosnakamas.persistenciadedatos.personajes.domain

import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personaje
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personajes

class SavePersonajesUseCase(
    private val repository: PersonajesRepository
) {
    fun excecute(personaje: Personaje) = repository.save(personaje)
}
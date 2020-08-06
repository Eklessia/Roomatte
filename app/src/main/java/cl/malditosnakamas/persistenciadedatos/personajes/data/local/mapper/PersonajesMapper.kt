package cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper

import cl.malditosnakamas.persistenciadedatos.personajes.data.local.database.PersonajeEntity
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personajes

class PersonajesMapper(
    private val personajeMapper: PersonajeMapper
) {

    fun mapRoomToDomain(list: List<PersonajeEntity>): Personajes {
        return Personajes(
            list.map { personajeEntity ->
                personajeMapper.mapRoomToDomain(personajeEntity)
            }
        )
    }
}
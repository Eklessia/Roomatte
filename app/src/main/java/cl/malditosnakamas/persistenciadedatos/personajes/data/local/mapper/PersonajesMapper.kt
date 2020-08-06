package cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper

import cl.malditosnakamas.persistenciadedatos.personajes.data.local.database.PersonajeEntity
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personaje
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

    fun mapDomainToRoom(personaje: Personaje) : PersonajeEntity{
        return PersonajeEntity(personaje.id, personaje.name, personaje.image)
    }
}
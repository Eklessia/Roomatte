package cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper

import cl.malditosnakamas.persistenciadedatos.personajes.data.local.database.PersonajeEntity
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personaje

class PersonajeMapper {

    fun mapRoomToDomain(roomEntity: PersonajeEntity) : Personaje{
        return Personaje(roomEntity.id, roomEntity.name, roomEntity.image)
    }
}
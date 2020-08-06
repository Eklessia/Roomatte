package cl.malditosnakamas.persistenciadedatos.personajes.data.local

import android.content.Context
import androidx.room.Room
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.database.PersonajeDataBase
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper.PersonajesMapper
import cl.malditosnakamas.persistenciadedatos.personajes.domain.PersonajesRepository
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personaje
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personajes
import io.reactivex.Completable
import io.reactivex.Single

class LocalPersonajesRepository(
    applicationContext: Context,
    private val personajesMapper: PersonajesMapper
) : PersonajesRepository {

    val db = Room.databaseBuilder(
        applicationContext,
        PersonajeDataBase::class.java, "database-personaje"
    ).build()

    override fun getAll(): Single<Personajes> {
        return db.personajesDao().getAll().map { list ->
            personajesMapper.mapRoomToDomain(list)
        }
    }

    override fun save(personaje: Personaje) {
        Completable.fromAction {
            db.personajesDao().insert(personajesMapper.mapDomainToRoom(personaje))
        }.subscribe()
    }
}
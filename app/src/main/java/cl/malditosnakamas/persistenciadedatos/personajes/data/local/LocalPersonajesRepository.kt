package cl.malditosnakamas.persistenciadedatos.personajes.data.local

import android.content.Context
import androidx.room.Room
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.database.PersonajeDataBase
import cl.malditosnakamas.persistenciadedatos.personajes.data.local.mapper.PersonajesMapper
import cl.malditosnakamas.persistenciadedatos.personajes.domain.PersonajesRepository
import cl.malditosnakamas.persistenciadedatos.personajes.domain.model.Personajes
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
        return Single.just(
            personajesMapper.mapRoomToDomain(
                db.personajesDao().getAll()
            )
        )
    }

    override fun saveAll(personajes: Personajes) {
        TODO("Not yet implemented")
    }
}
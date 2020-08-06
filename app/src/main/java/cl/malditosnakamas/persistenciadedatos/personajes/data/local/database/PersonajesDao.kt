package cl.malditosnakamas.persistenciadedatos.personajes.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface PersonajesDao {
    @Query("SELECT * FROM personaje")
    fun getAll(): Single<List<PersonajeEntity>>

    @Insert
    fun insertAll(vararg personajesEntity: PersonajeEntity)

    @Insert
    fun insert(personajeEntity: PersonajeEntity) : Single<Long>
}
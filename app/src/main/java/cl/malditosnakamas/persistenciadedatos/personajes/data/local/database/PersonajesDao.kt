package cl.malditosnakamas.persistenciadedatos.personajes.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonajesDao {
    @Query("SELECT * FROM personaje")
    fun getAll(): List<PersonajeEntity>

    @Insert
    fun insertAll(vararg personajesEntity: PersonajeEntity)

    @Insert
    fun insert(personajeEntity: PersonajeEntity)
}
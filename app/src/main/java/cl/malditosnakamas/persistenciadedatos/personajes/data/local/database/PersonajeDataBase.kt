package cl.malditosnakamas.persistenciadedatos.personajes.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonajeEntity::class], version = 1)
abstract class PersonajeDataBase : RoomDatabase() {
    abstract fun personajesDao(): PersonajesDao
}
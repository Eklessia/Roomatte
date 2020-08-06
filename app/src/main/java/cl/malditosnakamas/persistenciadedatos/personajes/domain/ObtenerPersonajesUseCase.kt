package cl.malditosnakamas.persistenciadedatos.personajes.domain

class ObtenerPersonajesUseCase(
    private val repository: PersonajesRepository
) {
    fun execute() = repository.getAll()
}
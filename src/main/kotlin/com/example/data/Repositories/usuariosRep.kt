package com.example.data.Repositories

import com.example.data.BaseRepositories
import com.example.data.entidades.usuario
import com.example.data.models.usuariosModel
import com.example.data.entidades.usuariosDAO
import org.jetbrains.exposed.sql.transactions.transaction

object usuariosRep: BaseRepositories<usuariosModel, Int>() {
    override fun crear(entity: usuariosModel)= transaction {

        entity.id = usuariosDAO.new {
            nombre = entity.nombre
            apellido = entity.apellido
            correo = entity.correo
            contrasena = entity.contrasena
            fecha_nacimiento = java.time.LocalDate.parse(entity.fecha_nacimiento)
            genero = entity.genero
            telefono = entity.telefono
            direccion = entity.direccion
            tipo_usuario = entity.tipo_usuario
            estado = entity.estado
        }.id.value
        return@transaction entity
    }

    override fun actualizar(t: usuariosModel, id: Int) = transaction {
        val user = usuariosDAO.findById(id) ?: throw Exception("Usuario no encontrado")
        if (user != null){
            user.nombre = t.nombre
            user.apellido = t.apellido
            user.correo = t.correo
            user.contrasena = t.contrasena
            user.fecha_nacimiento = java.time.LocalDate.parse(t.fecha_nacimiento)
            user.genero = t.genero
            user.telefono = t.telefono
            user.direccion = t.direccion
            user.tipo_usuario = t.tipo_usuario
            user.estado = t.estado
        }
        return@transaction t
    }

    /*override fun eliminar(id: Int): Boolean = transaction {
        return@transaction when (usuariosDAO.findById(id)) {
            null -> throw Exception("Usuario no encontrado")
            else -> {
                usuariosDAO.findById(id)?.delete()
                true
            }
        }
    }*/

    override fun eliminar(id: Int): Boolean = transaction {
        val user = usuariosDAO.findById(id)

        return@transaction if (user != null) {
            user.delete()
            true
        } else {
            false
        }
    }


    /*override fun buscarPorId(id: Int) = transaction{
        val user = usuariosDAO.findById(id) ?: throw Exception("Usuario no encontrado")
        return@transaction user.toUsuario()
    }*/

    override fun buscarPorId(id: Int): usuariosModel? = transaction {
        val user = usuariosDAO.findById(id)
        return@transaction user?.toUsuario()
    }


    override fun buscarTodos(): List<usuariosModel> = transaction{
        return@transaction usuariosDAO.all().map { it.toUsuario() }
    }
    /*override fun buscarTodos(): List<usuariosModel> = transaction{
        val usuarios = usuariosDAO.all().map { it.toUsuario() }
        usuarios.forEach { usuario ->
            println("ID: ${usuario.id}")
            println("Nombre: ${usuario.nombre}")
            println("Apellido: ${usuario.apellido}")
            println("Correo: ${usuario.correo}")
            // Agrega aquí más propiedades que quieras imprimir
            println() // Espacio en blanco entre usuarios
        }
        return@transaction usuarios
    }*/

    fun buscarPorCorreo(correo: String): Boolean = transaction{
        return@transaction when (usuariosDAO.find { usuario.correo eq correo }.count()) {
            0L -> false
            else -> true
        }
    }
}
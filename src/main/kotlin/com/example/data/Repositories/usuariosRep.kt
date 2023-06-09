package com.example.data.Repositories

import com.example.data.BaseRepositories
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
            fecha_nacimiento = entity.fecha_nacimiento
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
            user.fecha_nacimiento = t.fecha_nacimiento
            user.genero = t.genero
            user.telefono = t.telefono
            user.direccion = t.direccion
            user.tipo_usuario = t.tipo_usuario
            user.estado = t.estado
        }
        return@transaction t
    }

    override fun eliminar(id: Int): Boolean = transaction {
       /* val user = usuariosDAO.findById(id) ?: throw Exception("Usuario no encontrado")
        if (user != null){
            user.delete()
            return@transaction true
        }else{
            return@transaction false
        }*/
      //return@transaction usuariosDAO.findById(id)?.delete() ?: throw Exception("Usuario no encontrado")
        return@transaction when (usuariosDAO.findById(id)) {
            null -> throw Exception("Usuario no encontrado")
            else -> {
                usuariosDAO.findById(id)?.delete()
                true
            }
        }
    }

    override fun buscarPorId(id: Int) = transaction{
        val user = usuariosDAO.findById(id) ?: throw Exception("Usuario no encontrado")
        return@transaction user.toUsuario()
    }

    override fun buscarTodos(): List<usuariosModel> = transaction{
        return@transaction usuariosDAO.all().map { it.toUsuario() }
    }
}
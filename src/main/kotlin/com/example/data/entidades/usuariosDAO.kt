package com.example.data.entidades

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import com.example.data.models.usuariosModel

object usuario: IntIdTable("tb_usuarios") {
    val nombre = varchar("nombre", 50)
    val apellido = varchar("apellido", 50)
    val correo = varchar("correo", 50)
    val contrasena = varchar("contrasena", 50)
    val fecha_nacimiento = varchar("fecha_nacimiento", 50)
    val genero = varchar("genero", 50)
    val telefono = varchar("telefono", 50)
    val direccion = varchar("direccion", 50)
    val tipo_usuario = varchar("tipo_usuario", 50)
    val estado = varchar("estado", 50)
}

class usuariosDAO(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<usuariosDAO>(usuario)

    var nombre by usuario.nombre
    var apellido by usuario.apellido
    var correo by usuario.correo
    var contrasena by usuario.contrasena
    var fecha_nacimiento by usuario.fecha_nacimiento
    var genero by usuario.genero
    var telefono by usuario.telefono
    var direccion by usuario.direccion
    var tipo_usuario by usuario.tipo_usuario
    var estado by usuario.estado

    fun toUsuario() = usuariosModel(
        id.value,
        nombre,
        apellido,
        correo,
        contrasena,
        fecha_nacimiento,
        genero,
        telefono,
        direccion,
        tipo_usuario,
        estado
    )
}




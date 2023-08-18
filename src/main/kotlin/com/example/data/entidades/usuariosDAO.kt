package com.example.data.entidades

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import com.example.data.models.usuariosModel
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.javatime.date


object usuario: IntIdTable("tb_usuarios") {
    val nombre = varchar("nombre", 50)
    val apellido = varchar("apellido", 50)
    val correo = varchar("correo", 50)
    val contrasena = varchar("contrasena", 50)
    val fecha_nacimiento = date("fecha_nacimiento")
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
        fecha_nacimiento.toString(),
        genero,
        telefono,
        direccion,
        tipo_usuario,
        estado
    )


}

fun listarUser( users: List<usuariosModel>) {

    users.forEach{
        println("id: ${it.id}")
        println("Nombre: ${it.nombre}")
        println("Apellido: ${it.apellido}")
        println("Correo: ${it.correo}")
        println("Contraseña: ${it.contrasena}")
        println("Fecha de nacimiento: ${it.fecha_nacimiento}")
        println("Genero: ${it.genero}")
        println("Telefono: ${it.telefono}")
        println("Direccion: ${it.direccion}")
        println("Tipo de usuario: ${it.tipo_usuario}")
        println("Estado: ${it.estado}")
        println("-------------------------------------------------")
    }
}

fun listarUnUser(user: usuariosModel) {
    println("id: ${user.id}")
    println("Nombre: ${user.nombre}")
    println("Apellido: ${user.apellido}")
    println("Correo: ${user.correo}")
    println("Contraseña: ${user.contrasena}")
    println("Fecha de nacimiento: ${user.fecha_nacimiento}")
    println("Genero: ${user.genero}")
    println("Telefono: ${user.telefono}")
    println("Direccion: ${user.direccion}")
    println("Tipo de usuario: ${user.tipo_usuario}")
    println("Estado: ${user.estado}")
    println("-------------------------------------------------")
}



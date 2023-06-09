package com.example.data.models

import kotlinx.serialization.Serializable

@Serializable
data class usuariosModel(
    var id: Int,
    val nombre: String,
    val apellido: String,
    val correo: String,
    val contrasena: String,
    val fecha_nacimiento: String,
    val genero: String,
    val telefono: String,
    val direccion: String,
    val tipo_usuario: String,
    val estado: String
)

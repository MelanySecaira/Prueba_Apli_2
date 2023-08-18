package com.example

import com.example.data.ConexionBD
import com.example.data.entidades.usuariosDAO
import io.ktor.server.application.*
import com.example.plugins.*
import com.example.data.models.usuariosModel
import com.example.logic.usuarioLogic
import com.example.Menu.menuOP

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    ConexionBD.conectarPostgreSQL()
    //ConexionBD.conectarMySQL()
    configureRouting()
    //llamar al menu de opciones
    menuOP().menu()
}

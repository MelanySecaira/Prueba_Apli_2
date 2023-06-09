package com.example.data

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import com.example.data.entidades.usuario

object ConexionBD {
    fun conectar() {
        val url = "jdbc:postgresql://localhost:5432/prueba_2_parcial"
        val username = "postgres"
        val password = "secaira"
        val driver = "org.postgresql.Driver"

        try {
            Database.connect(url, driver, username, password)
            println("Conexion exitosa! :D")
            transaction {
                //createTable squema
                SchemaUtils.create(usuario)
            }
        }catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
}
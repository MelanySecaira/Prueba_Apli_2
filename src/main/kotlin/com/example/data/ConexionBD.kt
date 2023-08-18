package com.example.data

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import com.example.data.entidades.usuario

object ConexionBD {
    fun conectarPostgreSQL() {
        val url = "jdbc:postgresql://localhost:5432/prueba_2_parcial"
        val username = "postgres"
        val password = "secaira"
        val driver = "org.postgresql.Driver"

        try {
            Database.connect(url, driver, username, password)
            println("Conexion exitosa a Postgrest! :D")
            transaction {
                //createTable squema
                SchemaUtils.create(usuario)
            }
        }catch (e: Exception) {
            println("Error en la coneiòn a Postgrest: ${e.message}")
        }
    }

    fun conectarMySQL() {
        val url = "jdbc:mysql://localhost:3306/prueba_2_parcial"
        val username = "root"
        val password = "secaira"
        val driver = "com.mysql.jdbc.Driver"

        try {
            Database.connect(url, driver, username, password)
            println("¡Conexión exitosa a MySQL! :D")
            transaction {
                SchemaUtils.create(usuario)
            }
        } catch (e: Exception) {
            println("Error en la conexión a MySQL: ${e.message}")
        }
    }

    fun conectarSQLServer() {
        val url = "jdbc:sqlserver://localhost:1433;databaseName=prueba_2_parcial"
        val username = ""
        val password = ""
        val driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"

        try {
            Database.connect(url, driver, username, password)
            println("¡Conexión exitosa a SQL Server! :D")
            transaction {
                SchemaUtils.create(usuario)
            }
        } catch (e: Exception) {
            println("Error en la conexión a SQL Server: ${e.message}")
        }
    }

}
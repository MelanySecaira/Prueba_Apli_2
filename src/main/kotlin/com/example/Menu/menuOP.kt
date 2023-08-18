package com.example.Menu

import com.example.data.entidades.listarUnUser
import com.example.logic.usuarioLogic
import com.example.data.entidades.listarUser

class menuOP {

    fun menu(): Int{
        var opcion: Int
        /*
        println("=============== Menu ===============")
        println("1. Crear usuario")
        println("2. Actualizar usuario")
        println("3. Eliminar usuario")
        println("4. Buscar usuario por id")
        println("5. Buscar todos los usuarios")
        println("6. Salir")
        println("Ingrese una opcion: ")
        val opcion = readLine()!!.toInt()
        if (opcion !in 1..6){
            println("Opcion invalida")
            return menu()
        }
        accion(opcion);
        return opcion
        */
        do {
            println("=============== Menu ===============")
            println("1. Crear usuario")
            println("2. Actualizar usuario")
            println("3. Eliminar usuario")
            println("4. Buscar usuario por id")
            println("5. Buscar todos los usuarios")
            println("6. Salir")
            println("Ingrese una opcion: ")

            val input = readLine()

            if (input.isNullOrEmpty()) {
                opcion = 0
            } else {
                opcion = input!!.toIntOrNull() ?: 0
            }

            if (opcion !in 1..6) {
                println("Opcion invalida")
            } else {
                accion(opcion)
            }

        } while (opcion != 6)
        return opcion
    }
/*
    fun accion(opcion: Int){
        when(opcion){
            1 -> {
                val usuario = lecturaDatos().leerUsuario("usuario a crear")
                println("Datos del usuario a insertar "+usuario)
                val response = usuarioLogic().Create(usuario)
                println("repuesta del Insertar Usuario ----------> "+response)
                menu()
            }
            2 -> {
                val id = lecturaDatos().lerrID()
                println(id)

                val responseID = usuarioLogic().GetById(id)
                if(responseID == null){
                    println("--------------------------------")
                    println("No se encontro el usuario")
                    println("--------------------------------")

                }else{
                    println("--------------------------------")
                    println("Usuario encontrado")
                    println("--------------------------------")
                    listarUnUser(responseID)

                    val usuario = lecturaDatos().leerUsuario("usuario a actualizar")
                    val response = usuarioLogic().Update(usuario, id)
                    println("--------------------------------")
                    println("Usuario actualizado")
                    println("--------------------------------")
                    listarUnUser(response)
                }
                menu()
            }
            3 -> {
                println("Eliminar usuario")
                val id = lecturaDatos().lerrID()
                val restpuesta = usuarioLogic().Delete(id)
                println(restpuesta)
                if (restpuesta){
                    println("--------------------------------")
                    println("Usuario eliminado")
                    println("--------------------------------")

                }else{

                    println("--------------------------------")
                    println("No se encontro el usuario")
                    println("--------------------------------")

                }
                menu()
            }
            4 -> {
                println("Buscar usuario por id")
                val id = lecturaDatos().lerrID()
                println(id)

                val response = usuarioLogic().GetById(id)
                if(response == null){
                    println("--------------------------------")
                    println("No se encontro el usuario")
                    println("--------------------------------")

                }else{
                    println("--------------------------------")
                    println("Usuario encontrado")
                    println("--------------------------------")
                    listarUnUser(response)
                }
                menu()
            }
            5 -> {
                println("Buscar todos los usuarios")
                val response = usuarioLogic().GetAll()
                if (response.isEmpty()){
                    println("No hay usuarios registrados")
                }else{
                    println("--------------------------------")
                    println("Usuarios registrados")
                    println("--------------------------------")

                    listarUser(response)

                }
                menu()
            }
            6 -> {
                println("ADIOSITO DIJO MONCHITO")
            }
        }

    }

 */
fun accion(opcion: Int) {
    when (opcion) {
        1 -> crearUsuario()
        2 -> actualizarUsuario()
        3 -> eliminarUsuario()
        4 -> buscarUsuarioPorId()
        5 -> buscarTodosLosUsuarios()
        6 -> println("ADIOSITO DIJO MONCHITO")
    }
}

    fun crearUsuario() {
        val usuario = lecturaDatos().leerUsuario("usuario a crear")
        println("Datos del usuario a insertar $usuario")
        val response = usuarioLogic().Create(usuario)
        println("Respuesta del Insertar Usuario ----------> $response")
        menu()
    }

    fun actualizarUsuario() {
        println("Actualizar usuario")
        val id = lecturaDatos().lerrID()
        val responseID = usuarioLogic().GetById(id)

        if (responseID == null) {
            println("--------------------------------")
            println("No se encontró el usuario")
            println("--------------------------------")
        } else {
            println("--------------------------------")
            println("Usuario encontrado")
            println("--------------------------------")
            listarUnUser(responseID)

            val usuario = lecturaDatos().leerUsuario("usuario a actualizar")
            val response = usuarioLogic().Update(usuario, id)
            println("--------------------------------")
            println("Usuario actualizado")
            println("--------------------------------")
            listarUnUser(response)
        }
        menu()
    }

    fun eliminarUsuario() {
        println("Eliminar usuario")
        val id = lecturaDatos().lerrID()
        val restpuesta = usuarioLogic().Delete(id)
        println(restpuesta)

        if (restpuesta) {
            println("--------------------------------")
            println("Usuario eliminado")
            println("--------------------------------")
        } else {
            println("--------------------------------")
            println("No se encontró el usuario")
            println("--------------------------------")
        }
        menu()
    }

    fun buscarUsuarioPorId() {
        println("Buscar usuario por id")
        val id = lecturaDatos().lerrID()
        val response = usuarioLogic().GetById(id)

        if (response == null) {
            println("--------------------------------")
            println("No se encontró el usuario")
            println("--------------------------------")
        } else {
            println("--------------------------------")
            println("Usuario encontrado")
            println("--------------------------------")
            listarUnUser(response)
        }
        menu()
    }

    fun buscarTodosLosUsuarios() {
        println("Buscar todos los usuarios")
        val response = usuarioLogic().GetAll()

        if (response.isEmpty()) {
            println("No hay usuarios registrados")
        } else {
            println("--------------------------------")
            println("Usuarios registrados")
            println("--------------------------------")
            listarUser(response)
        }
        menu()
    }

}
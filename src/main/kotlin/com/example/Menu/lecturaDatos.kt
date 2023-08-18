package com.example.Menu

import com.example.data.models.usuariosModel

class lecturaDatos {

    /*
    fun leerUsuario(men: String) : usuariosModel{
        println("Ingrese los datos del "+men)
        println("Nombre: ")
        val nombre = readLine()!!
        println("Apellido: ")
        val apellido = readLine()!!
        println("Correo: ")
        val correo = readLine()!!
        println("Contraseña: ")
        val contrasena = readLine()!!

        println("Fecha de nacimiento (formato yyyy-mm-dd): ")
        val fecha_nacimiento = readLine()!!

        val regex = Regex("""^\d{4}-\d{2}-\d{2}$""")
        if (fecha_nacimiento.matches(regex)) {
            // La fecha tiene el formato correcto, puedes continuar con el procesamiento
        } else {
            println("Formato de fecha incorrecto. Debe ser yyyy-mm-dd.")
            println("Ingre la fecha de nacimiento nuevamente (formato yyyy-mm-dd): ")
            val fecha_nacimiento = readLine()!!
        }

        println("Genero: ")
        val genero = readLine()!!
        println("Telefono: ")
        val telefono = readLine()!!
        println("Direccion: ")
        val direccion = readLine()!!
        println("Tipo de usuario: ")
        val tipo_usuario = readLine()!!
        println("Estado: ")
        val estado = readLine()!!
        val usuario = usuariosModel(1,nombre,apellido,correo,contrasena,fecha_nacimiento,genero,telefono,direccion,tipo_usuario,estado)
        return usuario
    }*/

    fun leerUsuario(men: String): usuariosModel {
        println("Ingrese los datos del $men")
        val nombre = leerDato("Nombre")
        val apellido = leerDato("Apellido")
        val correo = leerDato("Correo")
        val contrasena = leerDato("Contraseña")
        val fecha_nacimiento = leerFecha("Fecha de nacimiento (formato yyyy-mm-dd)")
        val genero = leerDato("Genero")
        val telefono = leerDato("Telefono")
        val direccion = leerDato("Direccion")
        val tipo_usuario = leerDato("Tipo de usuario")
        val estado = leerDato("Estado")

        return usuariosModel(1, nombre, apellido, correo, contrasena, fecha_nacimiento, genero, telefono, direccion, tipo_usuario, estado)
    }

    fun leerDato(nombreDato: String): String {
        println("$nombreDato: ")
        return readLine()!!
    }

    fun leerFecha(mensaje: String): String {
        val regex = Regex("""^\d{4}-\d{2}-\d{2}$""")
        do {
            println(mensaje)
            val fecha_nacimiento = readLine()!!
            if (fecha_nacimiento.matches(regex)) {
                return fecha_nacimiento
            } else {
                println("Formato de fecha incorrecto. Debe ser yyyy-mm-dd.")
            }
        } while (true)
    }

    fun lerrID() : Int{
        println("Ingrese el id del usuario")
        val id = readLine()!!.toInt()
        return id
    }
}
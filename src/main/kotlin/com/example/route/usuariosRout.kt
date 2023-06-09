package com.example.route
import com.example.data.Repositories.cGenerica
import com.example.data.models.usuariosModel
import com.example.data.Repositories.usuariosRep
import com.example.logic.usuarioLogic
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val objUser = cGenerica<usuariosModel>();

fun Route.usuariosRouting() {

    route("/usuarios") {
        get {
            try {
                val response = usuarioLogic().GetAll()
                call.respond(HttpStatusCode.OK, response)
            }catch (cause: Throwable) {
                println(cause.message)
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }
        }

        post {
            val usuario = call.receive<usuariosModel>()
            try {
                val response = usuarioLogic().Create(usuario)
                call.respond(HttpStatusCode.Created, response)

            }catch (cause: Throwable) {
                println(cause.message)
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }
        }

        delete ("/{id}"){
            val id = call.parameters["id"]?.toIntOrNull() ?: 0
            try {
                val restpuesta = usuarioLogic().Delete(id)
                if (restpuesta!=null) {
                    call.respond(HttpStatusCode.OK, "Usuario eliminado correctamente")
                }else{
                    call.respond(HttpStatusCode.NotFound, "Usuario no encontrado")
                }
            }catch (cause: Throwable) {
                println(cause.message)
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }
        }

        put("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?: 0
            val usuario = call.receive<usuariosModel>()
            try {
                val user = usuarioLogic().GetById(id)
                if (user != null) {
                   // val response = usuarioLogic.Update(usuario, id)
                    val response = usuarioLogic().Update(usuario, id)
                    call.respond(HttpStatusCode.OK,response)
                } else {
                    call.respond(HttpStatusCode.NotFound, "Usuario no encontrado")
                }
            }catch (cause: Throwable) {
                println(cause.message)
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }
        }

        get ("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull() ?: 0
            try {
                val user = usuarioLogic().GetById(id)
                if (user != null) {
                    call.respond(HttpStatusCode.OK,user)
                } else {
                    call.respond(HttpStatusCode.NotFound, "Usuario no encontrado, sorry")
                }
            }catch (cause: Throwable) {
                println(cause.message)
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }
        }

    }
}
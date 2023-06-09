package com.example.data.Repositories

import com.example.data.models.usuariosModel
import java.lang.IllegalArgumentException

class cGenerica <T>{
    fun <T> gGetAll(obj: T): List<Any>{
        return when(obj) {
            is usuariosRep -> {
                obj.buscarTodos();
            }
            else -> throw IllegalArgumentException("Tipo de objeto no soportado");
        }
    }

    fun <T> gGetById(obj: T, id: Int): Any?{
        return when(obj) {
            is usuariosRep -> {
                obj.buscarPorId(id);
            }
            else -> throw IllegalArgumentException("Tipo de objeto no soportado");
        }
    }

    fun <T> gCreate(obj: T, entity: Any): Any{
        return when(obj) {
            is usuariosRep -> {
                obj.crear(entity as usuariosModel);
            }
            else -> throw IllegalArgumentException("Tipo de objeto no soportado");
        }
    }

    fun <T> gUpdate(obj: T, entity: Any, id: Int): Any{
        return when(obj) {
            is usuariosRep -> {
                obj.actualizar(entity as usuariosModel, id);
            }
            else -> throw IllegalArgumentException("Tipo de objeto no soportado");
        }
    }

    fun <T> gDelete(obj: T, id: Int): Any{
        return when(obj) {
            is usuariosRep -> {
                obj.eliminar(id);
            }
            else -> throw IllegalArgumentException("Tipo de objeto no soportado");
        }
    }


}
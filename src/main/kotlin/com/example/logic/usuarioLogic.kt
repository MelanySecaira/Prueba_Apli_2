package com.example.logic

import com.example.data.Repositories.cGenerica
import com.example.data.Repositories.usuariosRep
import com.example.data.models.usuariosModel

class usuarioLogic {
    val obj = cGenerica<usuariosRep>();

    fun GetAll(): List<usuariosModel>{
        if ( obj.gGetAll(usuariosRep) == null){
            return emptyList();
        }else{
            return obj.gGetAll(usuariosRep) as List<usuariosModel>;
        }
    }

    fun GetById(id: Int): usuariosModel?{
        if(obj.gGetById(usuariosRep, id) == null){
            return null;
        }else {
            return obj.gGetById(usuariosRep, id) as usuariosModel?;
        }
    }

   /* fun Create(entity: usuariosModel): usuariosModel{
        //mensaje de error si el usuario ya existe

        return obj.gCreate(usuariosRep, entity) as usuariosModel;
    }
*/
    /*
    fun Create(entity: usuariosModel): String{
        //mensaje de error si el usuario ya existe
        //comprobar que el correo electronico no se repita
        val res =  obj.gBuscar(usuariosRep, entity.correo);
        if(res == false){
            obj.gCreate(usuariosRep, entity);
            return "Usuario creado correctamente";
        }else{
            return "El correo electronico ya existe";
        }
    }

    fun Update(entity: usuariosModel, id: Int): usuariosModel{
        return obj.gUpdate(usuariosRep, entity, id) as usuariosModel;
    }


     */
   fun Create(entity: usuariosModel): String {
       val res = obj.gBuscar(usuariosRep, entity.correo)
       if (res==false) {
           if (validFecha(entity.fecha_nacimiento)) {
               obj.gCreate(usuariosRep, entity)
               return "Usuario creado correctamente"
           } else {
               return "La fecha de nacimiento es inválida"
           }
       } else {
           return "El correo electrónico ya existe"
       }
   }

    fun Update(entity: usuariosModel, id: Int): usuariosModel {
        if (validFecha(entity.fecha_nacimiento)) {
            return obj.gUpdate(usuariosRep, entity, id) as usuariosModel
        } else {
            throw IllegalArgumentException("La fecha de nacimiento es inválida")
        }
    }

    fun Delete(id: Int): Boolean{
        return obj.gDelete(usuariosRep, id) as Boolean;
    }

    fun validFecha(fecha: String): Boolean{
        val fechaActual = java.time.LocalDate.now();
        val fechaNacimiento = java.time.LocalDate.parse(fecha);
        if(fechaNacimiento.isAfter(fechaActual)){
            return false;
        }else{
            return true;
        }
    }
}
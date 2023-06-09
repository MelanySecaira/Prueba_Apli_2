package com.example.logic

import com.example.data.Repositories.cGenerica
import com.example.data.Repositories.usuariosRep
import com.example.data.models.usuariosModel

class usuarioLogic {
    val obj = cGenerica<usuariosRep>();

    fun GetAll(): List<usuariosModel>{
        return obj.gGetAll(usuariosRep) as List<usuariosModel>;
    }

    fun GetById(id: Int): usuariosModel?{
        return obj.gGetById(usuariosRep, id) as usuariosModel?;
    }

    fun Create(entity: usuariosModel): usuariosModel{
        return obj.gCreate(usuariosRep, entity) as usuariosModel;
    }

    fun Update(entity: usuariosModel, id: Int): usuariosModel{
        return obj.gUpdate(usuariosRep, entity, id) as usuariosModel;
    }

    fun Delete(id: Int): Boolean{
        return obj.gDelete(usuariosRep, id) as Boolean;
    }
}
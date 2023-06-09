package com.example.data

abstract class BaseRepositories <T, ID>{

    abstract fun crear(entity: T): T
    abstract fun actualizar(entity: T, id: ID): T
    abstract fun eliminar(id: ID): Boolean
    abstract fun buscarPorId(id: ID): T?
    abstract fun buscarTodos(): List<T>
}
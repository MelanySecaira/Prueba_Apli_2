﻿# Prueba de Aplicacciones II
 
 INTRUCCIONES DE USO
 Para inicializar la aplicaciòn, hacerlo en el archivo "Application.kt"
 se inciciara en la siguiente direcciòn y puerto: http://127.0.0.1:8080/
 
 /*Para probar usuarios*/
 
 Mètodo GET http://127.0.0.1:8080/usuarios
 Mètodo GET por ID http://127.0.0.1:8080/usuarios/1
 Mètodo POST http://127.0.0.1:8080/usuarios datos para probar:
 {
    "nombre": "Nllye",
     "apellido": "entity.apellido",
     "correo": "entity.correo",
     "contrasena": "entity.contrasena",
     "fecha_nacimiento": "entity.fecha_nacimiento",
     "genero": "entity.genero",
     "telefono": "entity.telefono",
     "direccion": "ciudadela olivos",
     "tipo_usuario": "entity.tipo_usuario",
     "estado": "entity.estado"
}
Mètodo PUT http://127.0.0.1:8080/usuarios/7
{  
    "nombre": "pablo01",
     "apellido": "entity.apelluhuhhuhjido",
     "correo": "entity.correo",
     "contrasena": "entity.contrasena",
     "fecha_nacimiento": "entity.fecha_nacimiento",
     "genero": "entity.genero",
     "telefono": "entity.telefono",
     "direccion": "ciudadela olivos",
     "tipo_usuario": "entity.tipo_usuario",
     "estado": "entity.estado"
}
Mètodo DELETE http://127.0.0.1:8080/usuarios/8

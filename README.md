Proyecto Final: Java Fundamentals
Este proyecto es una API RESTful para la creación de usuarios. La API está desarrollada utilizando el framework Spring Boot 3.1.0 y Java 17.

Descripción y Funcionalidades
El objetivo de este proyecto es implementar una API que permita crear usuarios y gestionar sus datos. La API acepta y devuelve únicamente datos en formato JSON, incluso para los mensajes de error. Todos los mensajes siguen el siguiente formato:

{
  "status": código de respuesta HTTP correspondiente,
  "mensaje": "mensaje de error"
}

Creación de Usuarios
El endpoint de creación de usuarios recibe los siguientes campos en formato JSON:
{
 "nombre":"juanicarlosto perezzzz",
  "password": "password4",
  "correo": "pedritaaaaao@example.com",
  "telefonos": [
      {
          "numero":11111111,
          "cod_ciudad":"1",
          "cod_pais":"1"
      }

  ]
}

La API responde con el código de estado HTTP adecuado. En caso de éxito, devuelve el usuario creado con los siguientes campos adicionales:

id: ID del usuario.
created: Fecha de creación del usuario.
modified: Fecha de la última actualización del usuario.
active: Indica si el usuario está habilitado en el sistema.
Si el correo ya existe en la base de datos, la API retorna un error "El correo ya está registrado".


Instrucciones de Instalación y Uso
1.Clona este repositorio en tu máquina local:
git clone https://github.com/Hellmuth99/ProyectoJavaEscalab.git

2.Accede al directorio del proyecto:
cd proyecto-java

3.Asegúrate de tener instalado Java JDK 17 y MySQL.

4.Crea una base de datos en MySQL utilizando el script de creación proporcionado.
En este caso solo seran suficientes estos dos comandos, ya que al compilar el programa, creará las tablas automáticamente.
CREATE DATABASE proyecto_java;
USE proyecto_java;

5.Modifica el archivo de configuración application.properties para ajustar la conexión a la base de datos.

6.Compila y construye el proyecto con Maven:
mvn clean install

7.Ejecuta el proyecto:
mvn spring-boot:run

La aplicación se iniciará y estará disponible en la siguiente URL: http://localhost:8080

Contribución
Se agradece cualquier contribución para mejorar este proyecto.

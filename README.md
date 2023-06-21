<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Proyecto Final: Java Fundamentals</h3>

 
</div>


<!-- ABOUT THE PROJECT -->
## Descripción y Funcionalidades

Este proyecto es una API RESTful para la creación de usuarios. La API está desarrollada utilizando el framework Spring Boot 3.1.0 y Java 17.

El objetivo de este proyecto es implementar una API que permita crear usuarios y gestionar sus datos. La API acepta y devuelve únicamente datos en formato JSON, incluso para los mensajes de error. Todos los mensajes siguen el siguiente formato:

```javascript
{ 
    "status": código de respuesta HTTP correspondiente, 
    "mensaje": "mensaje de error" 
}
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Creación de Usuarios

El endpoint de creación de usuarios recibe los siguientes campos en formato JSON:

```javascript
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
```

La API responde con el código de estado HTTP adecuado. En caso de éxito, devuelve el usuario creado con los siguientes campos adicionales:


Here's why:
* id: ID del usuario. 
* created: Fecha de creación del usuario.
* modified: Fecha de la última actualización del usuario. 
* active: Indica si el usuario está habilitado en el sistema.

Si el correo ya existe en la base de datos, la API retorna un error "El correo ya está registrado".


<p align="right">(<a href="#readme-top">back to top</a>)</p>




### Instrucciones de Instalación y Uso

1. Clona este repositorio en tu máquina local
 ```sh
   git clone https://github.com/Hellmuth99/ProyectoJavaEscalab.git
   ```
2. Accede al directorio
  
3. Asegúrate de tener instalado Java JDK 17 y MySQL.
4. Crea una base de datos en MySQL utilizando el script de creación proporcionado. En este caso solo seran suficientes estos dos comandos, ya que al compilar el programa, creará las tablas automáticamente. 
   ```js
   CREATE DATABASE proyecto_java; 
   USE proyecto_java;
   ```
5. Modifica el archivo de configuración application.properties para ajustar la conexión a la base de datos.
6. Compila y construye el proyecto con Maven: mvn clean install
7. Ejecuta el proyecto
 ```sh
mvn spring-boot:run
   ```

   La aplicación se iniciará y estará disponible en la siguiente URL: http://localhost:8080

   <p align="right">(<a href="#readme-top">back to top</a>)</p>

### Contribución
   Se agradece cualquier contribución para mejorar este proyecto.




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 

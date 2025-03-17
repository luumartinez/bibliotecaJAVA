<h1> Biblioteca - Gestión de Libros, Autores y Editoriales </h1>

<h3> Descripción </h3>
Este proyecto es una aplicación web para la gestión de una biblioteca. Permite la creación, edición y visualización de autores, libros y editoriales. Además, cuenta con un sistema de roles que diferencia entre Administradores y Usuarios

<strong> Usuarios: </strong> pueden visualizar libros, autores y editoriales.
</br>
<strong>Administradores: </strong>tienen permisos adicionales para gestionar usuarios (ver, editar y administrar sus permisos).

<h3>Tecnologías Utilizadas</h3>

<strong>Backend:</strong> Java con Spring Boot

<strong>Base de Datos:</strong> MySQL

<strong>Frontend:</strong> HTML
<strong>Autenticación:</strong> Spring Security

<h3>Uso de la Aplicación </h3>
<ol>
 <li>Registro e inicio de sesión: </li>
  
Los usuarios pueden registrarse e iniciar sesión.

<li>Gestión de Libros, Autores y Editoriales:</li>

Crear, editar y visualizar información.

<li>Roles y permisos:</li>

Un usuario estándar puede ver la biblioteca.

Un administrador tiene control total sobre los usuarios.
</ol>

<h3>API REST</h3>

Este proyecto sigue los principios de una API RESTful, lo que permite la comunicación entre el cliente y el servidor mediante peticiones HTTP. Se utilizan los siguientes métodos:

GET → Obtener recursos (libros, autores, editoriales, usuarios).

POST → Crear nuevos recursos.

PUT → Editar recursos existentes.

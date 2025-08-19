# Challenge Foro Hub 🗨️

## Objetivo
Este challenge consistió en desarrollar una **aplicación web de foro** llamada **Foro Hub**, utilizando **Spring Boot 3**.  
La aplicación permite a los usuarios **registrarse, crear temas, publicar respuestas y consultar información** sobre los foros de manera dinámica. Además, se gestionan **usuarios, cursos y categorías**, todo almacenado en una base de datos relacional mediante **JPA y Hibernate**.

El proyecto tiene como objetivo replicar funcionalidades comunes de un foro, aplicando los conocimientos adquiridos en el curso de **Alura** sobre desarrollo backend con Spring Boot.

---

## Aprendizaje
Durante el desarrollo del Foro Hub se reforzaron múltiples conceptos de **Java y Spring Boot 3**:

- **Spring Boot 3**: Configuración de proyectos modernos, autoconfiguración, manejo de dependencias y despliegue rápido de aplicaciones web.
- **REST API y Spring MVC**: Creación de endpoints para manejar operaciones sobre **usuarios, temas y respuestas**, usando `@RestController` y `@RequestMapping`.
- **Persistencia con JPA / Hibernate**: Mapear clases como `Usuario`, `Tema` y `Respuesta` a tablas de base de datos, gestionando relaciones `@ManyToOne` y `@OneToMany`.
- **Spring Data JPA**: Uso de **repositorios** para operaciones CRUD y consultas personalizadas sin necesidad de escribir SQL explícito.
- **Manejo de DTOs**: Separación entre entidades y objetos de transferencia para controlar los datos enviados y recibidos por la API.
- **Validaciones**: Implementación de anotaciones como `@NotNull`, `@Size` y `@Email` para asegurar integridad de los datos.
- **Relaciones entre entidades**: Gestión de temas con múltiples respuestas y usuarios asociados, evitando problemas comunes como `LazyInitializationException`.
- **Seguridad básica**: Manejo de roles de usuarios y validación de permisos para crear temas o responder en el foro.

---

## Manual de uso

La aplicación funciona mediante **endpoints REST**, que permiten registrar usuarios, crear temas, publicar respuestas y consultar información.

### Endpoints principales

1. **Usuarios**
    - `POST /usuarios` → Registrar un nuevo usuario.
    - `GET /usuarios` → Listar todos los usuarios registrados.
    - `GET /usuarios/{id}` → Consultar un usuario por su ID.

2. **Temas**
    - `POST /temas` → Crear un nuevo tema dentro de un curso o categoría.
    - `GET /temas` → Listar todos los temas disponibles.
    - `GET /temas/{id}` → Consultar detalles de un tema específico.

3. **Respuestas**
    - `POST /respuestas` → Publicar una respuesta en un tema existente.
    - `GET /respuestas/{idTema}` → Listar todas las respuestas de un tema.

4. **Filtrado y consultas**
    - Filtrar temas por curso, autor o estado (activo/cerrado).
    - Consultar usuarios por cantidad de temas creados o respuestas publicadas.

---

## Funcionalidades destacadas

- Registro y gestión de **usuarios** con roles y permisos.
- Creación y gestión de **temas** relacionados a cursos o categorías específicas.
- Publicación de **respuestas** en temas de manera dinámica.
- Consultas y filtrado de información para obtener estadísticas sobre participación de usuarios.
- Separación clara entre **entidades y DTOs** para un manejo seguro de datos.

---

## Tecnologías utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA / Hibernate**
- **MySQL / PostgreSQL (base de datos relacional)**
- **Maven** para gestión de dependencias
- **DTOs y Validaciones**
- **REST API con Spring MVC**
- **Seguridad básica de usuarios**

---

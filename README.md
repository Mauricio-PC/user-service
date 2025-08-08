# 🧑‍💻 User Service — PokeMicroServicios

Este microservicio forma parte del sistema **PokeMicroServicios**, una arquitectura distribuida basada en microservicios construida con **Spring Boot**, **JWT**, **Spring Security**, **MySQL** y **Eureka**.  
Su propósito es gestionar la entidad **Usuario**, incluyendo su perfil, edición, eliminación y acceso autenticado vía JWT.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.1.8
- Spring Web
- Spring Security
- Spring Data JPA
- MySQL
- JWT (JJWT 0.11.5)
- Lombok
- Swagger / OpenAPI 3
- Eureka Client

---

## 📦 Endpoints disponibles

### 🔓 Públicos
- `GET /api/users` → Listar todos los usuarios
- `GET /api/users/{username}` → Buscar usuario por username
- `POST /api/users` → Crear usuario
- `PUT /api/users/{id}` → Editar usuario
- `DELETE /api/users/{id}` → Eliminar usuario

### 🔐 Protegidos (requieren JWT)
- `GET /api/users/me` → Obtener el perfil del usuario autenticado

---

## 🔑 Seguridad

- Los tokens JWT son emitidos por el microservicio [`auth-service`](https://github.com/Mauricio-PC/auth-service).
- Este servicio **valida localmente** los tokens firmados usando una clave secreta compartida.
- Para acceder a `/api/users/me`, incluye el header: Authorization: Bearer <token-jwt>


---

## 🧪 Swagger disponible

Visita [http://localhost:8084/swagger-ui.html](http://localhost:8084/swagger-ui.html)  
para probar todos los endpoints desde el navegador.

---

## 🧰 Cómo correr el proyecto localmente

1. Asegúrate de tener corriendo:
   - MySQL
   - Eureka en `localhost:8701`

2. Crea la base de datos:

```sql
CREATE DATABASE user_db;
```

3. Clona este repo y navega al directorio:
   git clone https://github.com/Mauricio-PC/user-service.git
   cd user-service
4. Configura las credenciales en src/main/resources/application.yml
   spring:
   datasource:
    username: tu usuario
    password: tu contraseña
5. Ejecuta el proyecto desde IntelliJ o usando Maven:
   ./mvnw spring-boot:run
---

## 📡 Registro en Eureka
Este servicio se registra automáticamente en Eureka con el nombre USER-SERVICE.

---

## ✍️ Autor
Creado por Mauricio como parte del proyecto arquitectónico PokeMicroServicios.

---

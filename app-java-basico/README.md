# Aplicación Mensajes - API Restful con Spring Boot y PostgreSQL

Esta es una aplicación sencilla para gestionar mensajes. Construida utilizando **Spring Boot** y **PostgreSQL**, soporta operaciones básicas de CRUD a través de una API RESTful.

## Requisitos Previos

- **Java SDK 23**
- **Docker** y **Docker Compose**
- **PostgreSQL**

## Configuración del Proyecto

1. **Archivo de Configuración**

   La configuración del proyecto está contenida en `application.properties` y `application-docker.properties`. Estas propiedades incluyen detalles de conexión a la base de datos y otros ajustes.

   ```properties
   # application.properties
   server.port=9000

   spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
   spring.datasource.username=${DB_USER}
   spring.datasource.password=${DB_PASSWORD}

   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.hibernate.ddl-auto=update
   ```

   Asegúrate de configurar las variables de entorno para usar el archivo principal.

2. **Red de Docker Personalizada**

   Una red personalizada de Docker, llamada `mensajes-network`, asegura la comunicación entre contenedores.

## Estructura del Proyecto

- **Controladores**

    - `MensajeController.java`: Maneja los endpoints del API:
        - `GET /mensajes`: Recupera todos los mensajes.
        - `POST /mensajes`: Guarda un nuevo mensaje.

- **Modelos**

    - `Mensaje.java`: Representa la entidad de mensaje en la base de datos.

- **Servicios**
    - `MensajeService.java`: Contiene la lógica de negocio para manejar mensajes.

- **Repositorio**
    - `MensajeRepository.java`: Define la interfaz para la interacción con la base de datos.

---

## Scripts de Docker

### Iniciar la Aplicación

Puedes usar el script `run-mensajes-app.sh` para iniciar toda la aplicación en contenedores Docker.

```bash
./run-mensajes-app.sh
```

Este script:

1. Crea una red de Docker si no existe.
2. Inicia un contenedor con PostgreSQL.
3. Construye la imagen de la API Java y la ejecuta.

### Detener y Limpiar

El script `stop-clean-mensajes-app.sh` detiene todos los contenedores, elimina la red personalizada y, opcionalmente, elimina las imágenes de Docker.

```bash
./stop-clean-mensajes-app.sh
```

---

## Ejecutar Pruebas

Las pruebas unitarias pueden ejecutarse utilizando el siguiente comando:

```bash
./mvnw test
```

> **Nota:** Actualmente, no hay pruebas implementadas debido a la eliminación del archivo `AppJavaBasicoApplicationTests.java`.

---

## API Endpoints

### 1. Obtener Mensajes

**GET** `/mensajes`

**Respuesta:**

```json
{
  "totalMensajes": 0,
  "mensajes": []
}
```

### 2. Crear un Mensaje

**POST** `/mensajes`

**Body (JSON):**

```json
{
  "texto": "¡Hola Mundo!"
}
```

**Respuesta:**

`HTTP 201` - Mensaje creado exitosamente.

---

## Autor

Creado por **José Said Olano García**.

---

## Notas Finales

- Puedes ajustar los valores de conexión a base de datos y otros parámetros editando el archivo `application.properties` o pasando variables de entorno en los contenedores Docker.
- Esta es una aplicación sencilla que se puede extender añadiendo más funcionalidades o tests.
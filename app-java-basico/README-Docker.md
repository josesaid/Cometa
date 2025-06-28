# Guía para Desplegar la Aplicación Mensajes con Docker

Sigue los pasos descritos a continuación para desplegar la aplicación de mensajes utilizando contenedores Docker:

---

## 1. Crear una Red Personalizada de Docker

Primero, crea una red personalizada para facilitar la comunicación entre los contenedores.

```bash
docker network create mensajes-network
```

---

## 2. Ejecutar el Contenedor de la Base de Datos PostgreSQL

A continuación, inicia un contenedor de PostgreSQL en la red personalizada que acabas de crear. Este contenedor contendrá la base de datos necesaria para la aplicación.

```bash
docker run -p 5432:5432 --name postgres-mensajes-db-container \
    --network=mensajes-network \
    -e POSTGRES_USER=said \
    -e POSTGRES_PASSWORD=said \
    -e POSTGRES_DB=mensajes-db \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -v ./pgdata:/var/lib/postgresql/data \
    -d postgres
```

Detalles importantes:
- **Usuario de la base de datos:** `said`
- **Contraseña del usuario:** `said`
- **Nombre de la base de datos:** `mensajes-db`

La base de datos se almacenará en el directorio local `./pgdata`.

---

## 3. Construir la Imagen Docker para la API Java

Desde la raíz del proyecto, construye la imagen de Docker que contendrá la aplicación Java utilizando el archivo `Dockerfile`.

```bash
docker build -t mensajes-api-java .
```

- El flag `-t mensajes-api-java` asigna el nombre a la imagen resultante.

---

## 4. Ejecutar el Contenedor de la API Java

Finalmente, corre el contenedor de la API Java, asegurándote de conectarlo a la misma red personalizada que la base de datos.

```bash
docker run -p 9000:9000 --name mensajes-api-java-container \
    --network=mensajes-network \
    -e DB_HOST=postgres-mensajes-db-container \
    -e DB_PORT=5432 \
    -e DB_NAME=mensajes-db \
    -e DB_USER=said \
    -e DB_PASSWORD=said \
    mensajes-api-java
```

Detalles importantes:
- **DB_HOST:** Nombre del contenedor de PostgreSQL (`postgres-mensajes-db-container`).
- **DB_PORT:** Puerto del servicio de base de datos (5432).
- **DB_NAME:** Nombre de la base de datos que se conectará (`mensajes-db`).
- **DB_USER:** Usuario para conectarse a la base de datos (`said`).
- **DB_PASSWORD:** Contraseña para el usuario (`said`).

---

``` markdown
## Resultados

- La API se ejecutará en el puerto `9000` del host local. Accede a la API desde tu navegador o herramienta de pruebas en:  
  [http://localhost:9000](http://localhost:9000)

- Asegúrate de que tanto la base de datos como la aplicación Java estén corriendo en la red `mensajes-network` para que puedan comunicarse.

---

¡Y eso es todo! Tu aplicación ya debería estar funcionando correctamente. 🚀
```

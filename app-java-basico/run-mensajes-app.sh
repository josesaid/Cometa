#!/bin/bash

# Nombre de la red
NETWORK_NAME=mensajes-network

# Verifica si la red ya existe
if ! docker network ls | grep -q "$NETWORK_NAME"; then
  echo "⛵ Creando red Docker personalizada: $NETWORK_NAME"
  docker network create $NETWORK_NAME
else
  echo "✅ Red Docker '$NETWORK_NAME' ya existe"
fi

# Elimina contenedores previos si existen
echo "🧹 Limpiando contenedores previos..."
docker rm -f postgres-mensajes-db-container mensajes-api-java-container 2>/dev/null || true

# Corre el contenedor de PostgreSQL
echo "🐘 Iniciando contenedor PostgreSQL..."
docker run -p 5432:5432 --name postgres-mensajes-db-container \
  --network=$NETWORK_NAME \
  -e POSTGRES_USER=said \
  -e POSTGRES_PASSWORD=said \
  -e POSTGRES_DB=mensajes-db \
  -e PGDATA=/var/lib/postgresql/data/pgdata \
  -v ./pgdata:/var/lib/postgresql/data \
  -d postgres

# Construye la imagen de la API Java
echo "⚙️ Construyendo imagen Docker de la API Java..."
docker build -t mensajes-api-java .

# Corre el contenedor de la API Java
echo "🚀 Iniciando contenedor de la API Java..."
docker run -p 9000:9000 --name mensajes-api-java-container \
  --network=$NETWORK_NAME \
  -e DB_HOST=postgres-mensajes-db-container \
  -e DB_PORT=5432 \
  -e DB_NAME=mensajes-db \
  -e DB_USER=said \
  -e DB_PASSWORD=said \
  mensajes-api-java

echo "✅ Todo listo. API corriendo en http://localhost:9000"

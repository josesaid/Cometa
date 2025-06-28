#!/bin/bash

echo "🛑 Deteniendo y eliminando contenedores..."
docker rm -f mensajes-api-java-container postgres-mensajes-db-container 2>/dev/null || true

echo "🌐 Eliminando red personalizada..."
docker network rm mensajes-network 2>/dev/null || true

read -p "¿Deseas eliminar también la imagen Docker 'mensajes-api-java'? (s/n): " opcion
if [[ "$opcion" == "s" || "$opcion" == "S" ]]; then
  echo "🗑 Eliminando imagen Docker 'mensajes-api-java'..."
  docker rmi mensajes-api-java 2>/dev/null || true
else
  echo "👍 Imagen conservada."
fi

echo "✅ Limpieza completada."

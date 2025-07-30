#!/bin/bash

# ------------------------------------------------------------------------------------
# Inicia ms-pedidos con 2 instancias
JAR_NAME="./Pedido/target/Pedido-0.0.1.jar"
mkdir logs
echo "Iniciando ms-pedido instancia 1 en puerto 8081..."
nohup java -Dserver.port=8081 -jar $JAR_NAME > logs/ms-pedido-8081.log 2>&1 &

echo "Iniciando ms-pedido instancia 2 en puerto 8082..."
nohup java -Dserver.port=8082 -jar $JAR_NAME > logs/ms-pedido-8082.log 2>&1 &

echo "Instancias ms-pedido iniciadas. Verifica los logs en la carpeta 'logs/'."

# ------------------------------------------------------------------------------------
# Inicia ms-pagos con 2 instancias
JAR_NAME="./Pagos/target/Pagos-0.0.1-SNAPSHOT.jar"
mkdir logs
echo "Iniciando ms-pagos instancia 1 en puerto 8091..."
nohup java -Dserver.port=8091 -jar $JAR_NAME > logs/ms-pagos-8091.log 2>&1 &

echo "Iniciando ms-pagos instancia 2 en puerto 8092..."
nohup java -Dserver.port=8092 -jar $JAR_NAME > logs/ms-pagos-8092.log 2>&1 &

echo "Instancias ms-pagos iniciadas. Verifica los logs en la carpeta 'logs/'."

# ------------------------------------------------------------------------------------
# Inicia ms-productos con 2 instancias
JAR_NAME="./Productos/target/Productos-0.0.1-SNAPSHOT.jar"
mkdir logs
echo "Iniciando ms-productos instancia 1 en puerto 8101..."
nohup java -Dserver.port=8101 -jar $JAR_NAME > logs/ms-productos-8101.log 2>&1 &

echo "Iniciando ms-productos instancia 2 en puerto 8102..."
nohup java -Dserver.port=8102 -jar $JAR_NAME > logs/ms-productos-8102.log 2>&1 &

echo "Instancias ms-productos iniciadas. Verifica los logs en la carpeta 'logs/'."

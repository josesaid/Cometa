FROM openjdk:17-jdk-slim
#FROM openjdk:17-jre-slim
WORKDIR /app
COPY target/app-java-basico-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "app.jar"]

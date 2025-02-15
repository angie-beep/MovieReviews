# Verwende ein OpenJDK-Image
FROM openjdk:17-jdk-alpine

# Setze das Arbeitsverzeichnis
WORKDIR /app

# Kopiere das JAR-File in den Container (nach dem Build)
COPY target/*.jar app.jar

# Exponiere den Port (hier 8080)
EXPOSE 8080

# Starte die Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]

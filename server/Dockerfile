# Utilisation d'une image officielle OpenJDK comme image de base
FROM openjdk:11-jre-slim

# Définition du répertoire de travail dans le conteneur
WORKDIR /app

# Copie du fichier JAR de l'application dans le conteneur
COPY target/mdm-system-1.0-SNAPSHOT.jar /app/mdm-system.jar

# Exposition du port de l'application
EXPOSE 8080

# Commande pour démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "mdm-system.jar"]

# Commande par défaut
CMD ["--spring.profiles.active=prod"]

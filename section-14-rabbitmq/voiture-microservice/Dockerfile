#Start with a base image containing Java runtime
FROM eclipse-temurin:21-jre

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="adam.com"

# Add the application's jar to the image
COPY target/voiture-microservice-0.0.1-SNAPSHOT.jar voiture-microservice-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "voiture-microservice-0.0.1-SNAPSHOT.jar"]
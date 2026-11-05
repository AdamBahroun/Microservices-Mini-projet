#Start with a base image containing Java runtime
FROM eclipse-temurin:21-jre

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="adam.com"

# Add the application's jar to the image
COPY target/marque-0.0.1-SNAPSHOT.jar marque-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "marque-0.0.1-SNAPSHOT.jar"]
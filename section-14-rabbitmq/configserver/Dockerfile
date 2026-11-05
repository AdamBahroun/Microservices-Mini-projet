#Start with a base image containing Java runtime
FROM eclipse-temurin:21-jre

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="adam.com"

# Add the application's jar to the image
COPY target/configserver-0.0.1-SNAPSHOT.jar configserver-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "configserver-0.0.1-SNAPSHOT.jar"]

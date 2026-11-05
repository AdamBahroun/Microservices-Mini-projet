FROM eclipse-temurin:21-jre

LABEL "org.opencontainers.image.authors"="adam.com"

COPY target/message-0.0.1-SNAPSHOT.jar message-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "message-0.0.1-SNAPSHOT.jar"]

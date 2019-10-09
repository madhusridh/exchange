
FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8085

ARG JAR_FILE=target/NotificationClient-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} NotificationClient.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/NotificationClient.jar"]



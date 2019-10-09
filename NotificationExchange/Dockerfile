
FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8081

ARG JAR_FILE=target/NotificationExchange-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} NotificationExchange.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/NotificationExchange.jar"]


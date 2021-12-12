FROM openjdk:17-alpine

WORKDIR /opt/server
COPY ./target/TRSPO_USER_MANAGEMENT-0.0.1-SNAPSHOT.jar server.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "server.jar"]
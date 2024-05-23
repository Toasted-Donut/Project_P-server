FROM openjdk:17-alpine
WORKDIR server

COPY ./build/libs/server-0.0.1-SNAPSHOT.jar /server/app.jar
EXPOSE 8080

CMD ["java", "-jar", "/server/app.jar"]
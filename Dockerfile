FROM openjdk:21-jdk
COPY target/crudclientes-0.0.1-SNAPSHOT.jar /app/app.jar
CMD [ "java", "-jar", "/app/app.jar" ]
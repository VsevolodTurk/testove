FROM openjdk:22-jdk-oracle
ARG JAR_FILE=/home/runner/.m2/repository/com/example/demo/0.0.1-SNAPSHOT/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
#EXPOSE 8080
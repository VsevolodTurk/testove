FROM openjdk:22-jdk-oracle
#ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
COPY target/demo-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8080
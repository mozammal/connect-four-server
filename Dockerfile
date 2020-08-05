FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} connectfour.jar
ENTRYPOINT ["java", "-jar","/connectfour.jar"]
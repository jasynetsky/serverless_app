FROM openjdk:8-jdk-alpine
LABEL maintainer="jasynetsky@gmail.com"
EXPOSE 80
ADD target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
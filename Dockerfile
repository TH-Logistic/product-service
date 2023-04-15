#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
RUN mvn -f pom.xml clean package

#
# Package stage
#
FROM openjdk:latest
COPY target/product-service-0.0.1.jar product-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/product-service-0.0.1.jar"]
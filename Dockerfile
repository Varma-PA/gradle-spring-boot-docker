## Use an official Maven runtime as a parent image
#FROM gradle:8.5-jdk-focal AS build
#
## Set the working directory to /app
#WORKDIR /app
#
## Copy the current directory contents into the container at /app
#COPY . /app
#
## Build the application with Maven
#RUN mvn clean install -DskipTests
#RUN mvn package

FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle/src
#COPY . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon


# Use an official OpenJDK runtime as a parent image
#FROM openjdk:latest

FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file from the build stage to the current directory
EXPOSE 8080

WORKDIR /app

COPY --from=build /home/gradle/src/build/libs/*.jar ./spring-boot-application.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

#CMD ["java", "-jar", "app.jar"]

# docker compose up -d
# docker compose down --rmi local
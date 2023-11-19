FROM openjdk:21
LABEL authors="alseddek"
WORKDIR /app
COPY . .
COPY target/clinic.jar clinic.jar
ENTRYPOINT ["java", "-jar","clinic.jar "]
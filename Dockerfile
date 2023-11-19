FROM openjdk:17
LABEL authors="alseddek"
WORKDIR /app
COPY . .
COPY target/clinic.jar clinic.jar
ENTRYPOINT ["jav", "-jar","clinic.jar "]
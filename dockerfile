FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY src /app/src
COPY pom.xml /app

RUN mvn clean install -DskipTests

FROM eclipse-temurin:21.0.2_13-jdk

WORKDIR /app

COPY --from=build /app/target/meetimeapp-0.0.1-SNAPSHOT.jar /app/meetimeapp.jar

EXPOSE 8080

CMD ["java","-jar","meetimeapp.jar"]
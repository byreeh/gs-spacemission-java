FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
COPY pom.xml .
COPY src ./src
RUN apt-get update && apt-get install -y maven
RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/spacemission-1.0.0-SNAPSHOT-runner.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
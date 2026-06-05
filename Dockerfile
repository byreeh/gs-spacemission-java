FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y maven
RUN chmod +x mvnw && ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/spacemission-1.0.0-SNAPSHOT-runner.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
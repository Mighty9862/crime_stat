# Этап 1: Сборка приложения
FROM eclipse-temurin:22-jdk AS builder
WORKDIR /app
RUN apt-get update && apt-get install -y maven
COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests

# Этап 2: Runtime-образ для продакшена
FROM eclipse-temurin:22-jre-alpine
WORKDIR /app
RUN addgroup -g 1001 -S appgroup && \
    adduser -S appuser -u 1001 -G appgroup
USER appuser

COPY --from=builder /app/target/crime-api-1.0.0.jar app.jar

EXPOSE 8200

ENTRYPOINT ["java", "-jar", "app.jar"]
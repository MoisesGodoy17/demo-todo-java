# Etapa de build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -e -DskipTests package

# Etapa de runtime
FROM eclipse-temurin:17-jre
WORKDIR /app
# copia exactamente el jar empacado por spring-boot
COPY --from=build /app/target/app.jar app.jar
EXPOSE 8080
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]


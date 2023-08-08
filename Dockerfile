ARG BUILD_IMAGE=maven:3-openjdk-17-slim
ARG RUNTIME_IMAGE=eclipse-temurin:17-alpine

FROM ${BUILD_IMAGE} AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM ${RUNTIME_IMAGE}
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar /app/service.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/service.jar"]

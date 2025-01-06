FROM maven:3.8.4-openjdk-17-slim AS builder

WORKDIR /app
COPY pom.xml . 
COPY src ./src

RUN mvn clean install -DskipTests

FROM eclipse-temurin:17.0.6_10-jre

ENV SERVER_PORT=8080
ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_H2_CONSOLE_enabled=true
ENV AUI_GATEWAY_HOST=localhost:8080
ENV AUI_WEAPON_URL=http://localhost:8081
ENV AUI_WEAPONTYPE_URL=http://localhost:8082

COPY --from=builder /app/target/*.jar /opt/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/opt/app.jar"]

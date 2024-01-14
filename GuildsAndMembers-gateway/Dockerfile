FROM eclipse-temurin

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:GuildsAndMembers-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV VERSION="0.0.1-SNAPSHOT"

ENV GM_GATEWAY_HOST=localhost:8080
ENV GM_GUILD_URL=http://localhost:8081
ENV GM_MEMBER_URL=http://localhost:8082

EXPOSE 8080

COPY target/Gateway-${VERSION}.jar /opt/GuildsAndMembers-gateway/GuildsAndMembers-gateway.jar

CMD ["java", "-jar", "/opt/GuildsAndMembers-gateway/GuildsAndMembers-gateway.jar"]

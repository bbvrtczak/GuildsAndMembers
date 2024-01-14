FROM eclipse-temurin

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:GuildsAndMembers-guild
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV GM_MEMBER_URL=http://localhost:8082

ENV VERSION="0.0.1-SNAPSHOT"

EXPOSE 8080

COPY target/Guild-${VERSION}.jar /opt/GuildsAndMembers-guild/GuildsAndMembers-guild.jar

CMD ["java", "-jar", "/opt/GuildsAndMembers-guild/GuildsAndMembers-guild.jar"]

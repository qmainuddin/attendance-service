FROM openjdk:17
MAINTAINER Pratima Shah

WORKDIR /app

COPY target/attendance-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

CMD ["java", "-jar", "attendance-service-0.0.1-SNAPSHOT.jar"]
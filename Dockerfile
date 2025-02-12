FROM openjdk:17
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/springBootTest-0.0.1-SNAPSHOT.jar /app/springBootTest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/springBootTest-0.0.1-SNAPSHOT.jar"]
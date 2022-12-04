FROM openjdk:14

WORKDIR /home/springProj

COPY target/SpringProject-1.0-SNAPSHOT.jar /home/springProj

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "SpringProject-1.0-SNAPSHOT.jar"]
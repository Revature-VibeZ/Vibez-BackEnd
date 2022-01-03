FROM openjdk:8-jdk-alpine
COPY target/vibez.jar vibez.jar 
ENTRYPOINT ["java", "-jar", "/vibez.jar"]

FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD ./target/*.jar app.jar
ADD ./src/main/resources/ config

ENTRYPOINT ["java", "-Xmx200m", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar", "--spring.config.location=/config/application.yml", "--spring.profiles.active=docker"]

FROM maven:3.5-jdk-8 as build

WORKDIR /usr/src/angular-spring-heroes
COPY . /usr/src/angular-spring-heroes
RUN mvn install

###

FROM gcr.io/distroless/java:latest

EXPOSE 8080
WORKDIR /opt/app-root
VOLUME /tmp
ENTRYPOINT ["/usr/bin/java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=2", "-Xss512k", "-jar", "/opt/app-root/app.jar"]
COPY --from=build /usr/src/angular-spring-heroes/heroes-webapp/target/heroes-webapp.jar /opt/app-root/app.jar

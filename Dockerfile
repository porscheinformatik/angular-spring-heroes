FROM maven:3.5-jdk-8 as build

WORKDIR /usr/src/angular-spring-heroes
COPY . /usr/src/angular-spring-heroes
RUN mvn package

###

FROM openjdk:8-jre-slim

EXPOSE 8080
WORKDIR /opt/app-root
VOLUME /tmp
ENV JAVA_OPTS_MEM="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=2 -Xss512k"
ENV JAVA_OPTS=
ENTRYPOINT exec java $JAVA_OPTS_MEM $JAVA_OPTS -jar /opt/app-root/app.jar
COPY --from=build /usr/src/angular-spring-heroes/heroes-webapp/target/heroes-webapp.jar /opt/app-root/app.jar

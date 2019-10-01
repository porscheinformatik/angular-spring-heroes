FROM maven:3.6-jdk-11 as build

WORKDIR /usr/src/angular-spring-heroes
COPY . /usr/src/angular-spring-heroes
ENV CI=true
RUN mvn -B install

###

FROM openjdk:11-jre-slim

EXPOSE 8080
WORKDIR /opt/app-root
VOLUME /tmp
ENV JAVA_OPTS_MEM="-XX:MaxRAMPercentage=60 -Xss512k"
ENV JAVA_OPTS=
ENTRYPOINT exec java $JAVA_OPTS_MEM $JAVA_OPTS -jar /opt/app-root/app.jar
COPY --from=build /usr/src/angular-spring-heroes/heroes-webapp/target/heroes-webapp.jar /opt/app-root/app.jar

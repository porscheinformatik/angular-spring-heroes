FROM docker.porscheinformatik.com/eenv/builders/default:jdk-11 as build

USER root
COPY . /usr/src/angular-spring-heroes
WORKDIR /usr/src/angular-spring-heroes
RUN mvn -B install

###

FROM docker.porscheinformatik.com/eenv/openjdk:11-jre

EXPOSE 8080
WORKDIR /opt/app-root
VOLUME /tmp
ENV JAVA_OPTS_MEM="-XX:MaxRAMPercentage=60 -Xss512k"
ENV JAVA_OPTS=
ENTRYPOINT exec java $JAVA_OPTS_MEM $JAVA_OPTS -jar /opt/app-root/app.jar
COPY --from=build /usr/src/angular-spring-heroes/heroes-webapp/target/heroes-webapp.jar /opt/app-root/app.jar

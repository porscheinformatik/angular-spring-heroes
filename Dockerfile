FROM docker.porscheinformatik.com/builders/default as build

USER root
COPY . /usr/src/angular-spring-heroes
WORKDIR /usr/src/angular-spring-heroes
RUN mvn -B install

###

FROM docker.porscheinformatik.com/java:8

EXPOSE 8080
WORKDIR /opt/app-root
VOLUME /tmp
ENV JAVA_OPTS_MEM="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=2 -Xss512k"
ENV JAVA_OPTS=
ENTRYPOINT exec java $JAVA_OPTS_MEM $JAVA_OPTS -jar /opt/app-root/app.jar
COPY --from=build /usr/src/angular-spring-heroes/heroes-webapp/target/heroes-webapp.jar /opt/app-root/app.jar

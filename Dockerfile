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
ENV JAVA_OPTS="-javaagent:/opt/jolokia-jvm-agent.jar=port=8778,host=0.0.0.0,protocol=https"
RUN curl -Lo /opt/jolokia-jvm-agent.jar "http://search.maven.org/remotecontent?filepath=org/jolokia/jolokia-jvm/1.6.2/jolokia-jvm-1.6.2-agent.jar"
ENTRYPOINT exec java $JAVA_OPTS_MEM $JAVA_OPTS -jar /opt/app-root/app.jar
COPY --from=build /usr/src/angular-spring-heroes/heroes-webapp/target/heroes-webapp.jar /opt/app-root/app.jar

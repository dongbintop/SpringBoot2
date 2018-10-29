FROM openjdk:8-jre-alpine

MAINTAINER W23123

RUN mkdir -p /opt/apps

ADD target/springboot2-0.0.1.jar /opt/apps

ENV JAVA_APP_JAR=/opt/apps/springboot2-0.0.1.jar

CMD java -jar $JAVA_APP_JAR
FROM alpine:latest

MAINTAINER FIT2CLOUD <dongbin@fit2cloud.com>

RUN mkdir -p /opt/apps

ADD target/springboot2-0.0.1.jar /opt/apps

ENV JAVA_APP_JAR=/opt/apps/springboot2-0.0.1.jar

ENV AB_OFF=true

ENV JAVA_OPTIONS=-Dfile.encoding=utf-8

HEALTHCHECK --interval=15s --timeout=5s --retries=20 --start-period=30s CMD curl -f 127.0.0.1:6602

CMD ["/deployments/run-java.sh"]
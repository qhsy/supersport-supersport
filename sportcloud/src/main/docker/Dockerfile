FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD sportcloud-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Duser.timezone=Asia/Shanghai","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.config.location=/opt/zooconfig/config.properties"]
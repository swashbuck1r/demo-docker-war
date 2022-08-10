FROM openjdk:11

ADD build/libs/SpringBootServer-0.0.1-SNAPSHOT.war /opt/SpringBootServer.war

ENTRYPOINT [ "java", "-jar", "/opt/SpringBootServer.war" ]

EXPOSE 8080

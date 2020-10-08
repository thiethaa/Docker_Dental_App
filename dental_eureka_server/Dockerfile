FROM openjdk:latest
EXPOSE 8761
ADD target/eureka_server.jar eureka_server.jar
ENTRYPOINT ["java","-jar","eureka_server.jar"]
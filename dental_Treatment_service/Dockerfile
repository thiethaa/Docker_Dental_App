FROM openjdk:latest
ADD target/treatment_service.jar treatment_service.jar
EXPOSE 8020
ENTRYPOINT ["java","-jar","treatment_service.jar"]
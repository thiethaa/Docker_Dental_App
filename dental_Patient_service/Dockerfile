FROM openjdk:latest
ADD target/patient_service.jar patient_service.jar
EXPOSE 8040
ENTRYPOINT ["java","-jar","patient_service.jar"]
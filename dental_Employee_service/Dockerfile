FROM openjdk:latest
ADD target/employee_service.jar employee_service.jar
EXPOSE 8030
ENTRYPOINT ["java","-jar","employee_service.jar"]
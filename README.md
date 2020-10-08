# Docker_Dental_App
docker image :
          
https://hub.docker.com/repository/docker/thiethaa/dental-ui

https://hub.docker.com/repository/docker/thiethaa/dental-eureka

https://hub.docker.com/repository/docker/thiethaa/dental-treatment

https://hub.docker.com/repository/docker/thiethaa/dental-employee

https://hub.docker.com/repository/docker/thiethaa/dental-patient

            
Step by Step dockerize microservice:
1. build jar file
                    
                    mvn install -DskipTests
                    
2. create docker-compose.yml file on the main root folder : https://github.com/thiethaa/Docker_Dental_App/blob/master/docker-compose.yml
3. build image

                    docker-compose up -d dental-mysql
                    docker-compose up -d eureka-server
                    docker-compose up
4. run App on localhost:3000
5. stop server

                    docker-compose down

Step by step pull docker image, create and run it. locally:
1. create Empty directory and create docker-compose.yml then Copy-Paste this yml file:
          version: '3'

services:

    version: '3'

services:
    eureka-server:
        image: thiethaa/dental-eureka
        ports:
        -   8761:8761

    dental-mysql:
        image: mysql:latest
        environment:
            - MYSQL_ROOT_PASSWORD=password
            - MYSQL_DATABASE=dental_clinic
            - MYSQL_USER=root
            - MYSQL_PASSWORD=password
            - MYSQL_NAME=dental_app
        ports:
            - 1010:3306

    treatment-service:
        image: thiethaa/dental-treatment
        depends_on:
            - eureka-server
            - dental-mysql
        ports:
            - 8020:8020
        environment:
            - DATABASE_URL=jdbc:mysql://dental-mysql:3306/dental_clinic?serverTimezone=UTC
            - DATABASE_HOST=dental-mysql
            - DATABASE_USER=root
            - DATABASE_PASSWORD=password
            - DATABASE_NAME=dental_clinic
            - eureka.client.serviceUrl.defaultZone=http://eureka-server:8761/eureka

    employee-service:
        image: thiethaa/dental-employee
        depends_on:
            - eureka-server
            - dental-mysql
        ports:
            - 8030:8030
        environment:
            - DATABASE_URL=jdbc:mysql://dental-mysql:3306/dental_clinic?serverTimezone=UTC
            - DATABASE_HOST=dental-mysql
            - DATABASE_USER=root
            - DATABASE_PASSWORD=password
            - DATABASE_NAME=dental_clinic
            - eureka.client.serviceUrl.defaultZone=http://eureka-server:8761/eureka

    patient-service:
        image: thiethaa/dental-patient
        depends_on:
            - eureka-server
            - dental-mysql
        ports:
            - 8040:8040
        environment:
            - DATABASE_URL=jdbc:mysql://dental-mysql:3306/dental_clinic?serverTimezone=UTC
            - DATABASE_HOST=dental-mysql
            - DATABASE_USER=root
            - DATABASE_PASSWORD=password
            - DATABASE_NAME=dental_clinic
            - eureka.client.serviceUrl.defaultZone=http://eureka-server:8761/eureka

    dental-ui:
        image: thiethaa/dental-ui
        command: npm run start
        depends_on:
            -   eureka-server
        ports:
            - "3000:3000"

2. 
          docker-compose up -d dental-mysql
3.
          docker-compose up
          
4. go to port : localhost 3000
        login for setting up the app:
                    
                    username  : admin
                    password  : password
                    
5. To Stop the Server
          docker-compose down

add dental_Services>> open Postman : 
          
          form data (file:file, text:title,text:description)
          POST: http://localhost:8020/dentaltreatments/uploadTreatment  
          
add dental_employee >> open Postman : 
          
          form data (file:file,text:name, text:position,text:email,text:fb,text:twitter,text:ig,text:phone)
          POST: http://localhost:8030/dentalemployee/addEmployee
        

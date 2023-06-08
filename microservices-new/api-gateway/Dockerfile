FROM openjdk:17

COPY target/*.jar app.jar

ENTRYPOINT [ "java","-jar","/app.jar" ]
# docker build -t apigateway-dockerfile: builds docker image with jdk 17 
# docker images: returns all local images
#########################################
#            BUILD PROCESS              #
#########################################
FROM openjdk:8-jdk-alpine as build

WORKDIR /workspace/app

# /workspace/app
COPY ./mvnw.cmd   .
COPY ./mvnw       .
COPY ./.mvn       .mvn/

COPY ./pom.xml    .
COPY ./src        src

RUN ./mvnw clean install -DskipTests

#######################################
#            RUN PROCESS              #
#######################################

# Obtuve la respuesta al problema de no poder visualizar la aplicacion de un usuario de internet
# Aqui: https://forums.docker.com/t/unable-to-access-the-war-on-tomcat-container-404-not-found/83231/3

FROM tomcat:9.0.1-jre8-alpine

RUN adduser -D tomcat; chown -R tomcat:tomcat /usr/local/tomcat
USER tomcat

COPY --from=build "/root/.m2/repository/Cifrado/Cifrado/0.0.1-SNAPSHOT/*.war" /usr/local/tomcat/webapps/cifrado.war

CMD ["catalina.sh", "run"]

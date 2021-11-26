#########################################
#            BUILD PROCESS              #
#########################################
FROM adoptopenjdk/maven-openjdk11:latest as build
WORKDIR /workspace/app

# RUN adduser -D tomcat; chown -R tomcat:tomcat /workspace/app
# USER tomcat



# /workspace/app
COPY ./mvnw.cmd   .
COPY ./mvnw       .
COPY ./.mvn       .mvn/

COPY ./pom.xml    .
COPY ./src        src

RUN ./mvnw install -DskipTests

#######################################
#            RUN PROCESS              #
#######################################

# Obtuve la respuesta al problema de no poder visualizar la aplicacion de un usuario de internet
# Aqui: https://forums.docker.com/t/unable-to-access-the-war-on-tomcat-container-404-not-found/83231/3

FROM tomcat:8.5-jre8-alpine


COPY --from=build /root/.m2/repository/Cifrado/Cifrado/0.0.1-SNAPSHOT/*.war /usr/local/tomcat/webapps/cifrado.war

RUN ls -la /usr/local/tomcat/webapps


CMD ["catalina.sh", "run"]

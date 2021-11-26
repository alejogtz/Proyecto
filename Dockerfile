#########################################
#            BUILD PROCESS              #
#########################################
FROM maven:3.5-jdk-8 as build

COPY src /usr/src/myapp/src
COPY pom.xml /usr/src/myapp
RUN mvn -f /usr/src/myapp/pom.xml clean package

RUN jar -tf /usr/src/myapp/target/Cifrado-0.0.1-SNAPSHOT.war

#######################################
#            RUN PROCESS              #
#######################################

# Obtuve la respuesta al problema de no poder visualizar la aplicacion de un usuario de internet
# Aqui: https://forums.docker.com/t/unable-to-access-the-war-on-tomcat-container-404-not-found/83231/3

FROM tomcat:9.0

EXPOSE 8080
COPY --from=build /usr/src/myapp/target/Cifrado-0.0.1-SNAPSHOT /usr/local/tomcat/webapps/cifrado

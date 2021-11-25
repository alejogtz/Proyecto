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

FROM tomcat:9.0.1-jre8-alpine

COPY --from=build /root/.m2/repository/Cifrado/Cifrado/0.0.1-SNAPSHOT/Cifrado-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/Cifrado.war

CMD ["catalina.sh", "run"]

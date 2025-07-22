#Start with a base image containing Java runtime
FROM openjdk:17-jdk as build

LABEL maintainer="Kelvin Iseh <kelviniseh25@gmail.com>"

WORKDIR application

ARG JAR_FILE

COPY ${JAR_FILE} application.jar

#unpackage jar file
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17-jdk
WORKDIR application

COPY --from=build application/dependencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/application/ ./

#execute the application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.optimagrowth.organizationservice.OrganizationServiceApplication"]
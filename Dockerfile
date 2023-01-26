##FROM openjdk:17
##ADD target/chatgpt-0.1.jar chatgpt-0.1.jar
##EXPOSE 8080
##ENTRYPOINT ["java","-jar","chatgpt-0.1.jar"]

#FROM maven:3.6.0-jdk-11-slim AS build
#RUN mkdir -p /ws
#WORKDIR /ws
#COPY pom.xml /ws
#COPY src /ws/src
#CMD mvn -DskipTests=true clean package
#FROM openjdk:17
#COPY --from=build /ws/target/*.jar chatgpt-0.1.jar
##ADD target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","chatgpt-0.1.jar"]



# image layer
#WORKDIR /app
#ADD pom.xml /app
#RUN mvn verify clean --fail-never

# Image layer: with the application
#COPY . /app
#RUN mvn -v
#RUN mvn clean install -DskipTests
#ADD ./target/chatgpt-0.1.jar /deploy/
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/deploy/chatgpt-0.1.jar"]



FROM maven:3.8.3-openjdk-17 AS build
RUN mkdir -p /ws
WORKDIR /ws
COPY pom.xml /ws
COPY src /ws/src
RUN mvn -f pom.xml -Dmaven.test.skip  clean package

FROM openjdk:17
COPY --from=build /ws/target/*.jar chatgpt-0.1.jar
#ADD target/*.jar app.jar
EXPOSE 8080
VOLUME /chatgpt/data
ENTRYPOINT ["java","-jar","chatgpt-0.1.jar"]











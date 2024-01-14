FROM maven:3.8.5-openjdk-17
WORKDIR ./
COPY ./target/spring-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java","-jar","spring-0.0.1-SNAPSHOT.jar"]
#FROM maven:3.8.5-openjdk-17
#WORKDIR ./
#COPY . .
#RUN mvn clean install
#CMD mvn spring-boot:run

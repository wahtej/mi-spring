FROM ubuntu:latest
RUN apt-get update
RUN apt install -y openjdk-8-jdk
WORKDIR ./mi-spring
COPY /target/Max-Doctor-PatientApp-0.0.1-SNAPSHOT.jar /mi-spring
EXPOSE 8080
CMD ["java", "-jar", "Max-Doctor-PatientApp-0.0.1-SNAPSHOT.jar"]

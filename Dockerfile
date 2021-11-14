FROM openjdk:8-jdk-alpine
EXPOSE 8081
#ADD target/timesheet-1.0.jar timesheet-1.0.jar
ADD http://host.docker.internal:8081/repository/maven-releases/tn/esprit/spring/timesheet-devops/1.0/timesheet-1.0.jar timesheet-1.0.jar

ENTRYPOINT ["java","-jar","/timesheet-1.0.jar"]
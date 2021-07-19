FROM openjdk:8
EXPOSE 8764
ADD target/mncManagement-0.0.1-SNAPSHOT.jar mncmanagement.jar
ENTRYPOINT ["java","-jar","mncmanagement.jar"]
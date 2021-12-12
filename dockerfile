FROM openjdk:8-jdk-alpine
ADD /target/purchaseservice-0.0.1-SNAPSHOT.jar purchaseservice.jar
EXPOSE 9088
ENTRYPOINT ["java","-jar","/purchaseservice.jar"]

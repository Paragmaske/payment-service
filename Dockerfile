FROM openjdk:17-alpine
ADD target/payment-0.0.1-SNAPSHOT.jar paymentservice.jar
ENTRYPOINT ["java","-jar","/paymentservice.jar"]



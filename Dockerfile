FROM openjdk:8
ADD target/customer.amount-0.0.1-SNAPSHOT.war customer.amount-0.0.1-SNAPSHOT.war
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "customer.amount-0.0.1-SNAPSHOT.war"]
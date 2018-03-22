# Example Spring Cloud Streams w/ Kafka project

This project provides a simple structure to start with Spring Cloud Streams. 

## Maven modules:

* cloudstreamproducer: Sets up a simple web application for sending a greeting message 
* cloudstreamconsumer: a simple application receiving and outputing the greeting message to a log

##Requirements

* maven
* jdk 1.8
* Docker/Docker compose


##To run

Start up the kafka server via docker-compose

    docker-compose up -d
    
To build the jar: 

   mvn package
   
Then start up each module's jar in it's own terminal window:

    java -jar cloudstreamconsumer/target/cloud-stream-consumer-0.0.1-SNAPSHOT.jar
    java -jar cloudstreamproducer/target/cloud-stream-producer-0.0.1-SNAPSHOT.jar
    
Then using your browser or favorite http cli make the request to the producer rest endpont

    http localhost:8081/greet/homer

You should see the name "homer" in the log of the consumer. Ex. 

    2018-03-22 12:50:45.980  INFO 11545 --- [container-0-C-1] c.e.cloudstream.ConsumerApplication      : homer

##Resources

[Getting Started on Spring.io site](http://cloud.spring.io/spring-cloud-stream/)
| [Docs](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/)
| [Examples](https://github.com/spring-cloud/spring-cloud-stream-samples)

Two great courses:

* [Building microservices with Spring Boot, Second Edition](https://www.safaribooksonline.com/library/view/building-microservices-with/9780134678658/) by @joshlong and @philwebb
* [Cloud Native Java](https://www.safaribooksonline.com/library/view/cloud-native-java/9780134690377/) by @joshlong
     

    

Thorntail EE Concurrency example with Contextual instance example 
=====================================

Example taken from [Practical Enterprise & Microservices development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of EE Concurrency with a Contextual instance 

###### Deploy
```shell
mvn clean thorntail:run
```
###### Test
```shell
http://localhost:8080 
```
**Note** In order to propagate the Principal identity in the Proxy, it would be necessary to include a Security context in this application

 
 

Basic JMS example
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of a JMS 2.0 application

###### Pre-requisites:
You need the following Queue Definition in a full/full-ha profile:

```shell
 <jms-queue name="ExampleQueue" entries="queue/exampleQueue java:/jboss/exported/jms/queue/exampleQueue"/>
```

###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/javaee7-jms-basic
```
 

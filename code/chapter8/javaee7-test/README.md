Arquillian example application
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates how to test a basic JPA application using Arquillian 

###### Build 
```shell
mvn clean install 
```

###### Managed Test
```shell
mvn test -Parq-wildfly-managed
```

###### Remote Test
```shell
mvn test -Parq-wildfly-remote
```


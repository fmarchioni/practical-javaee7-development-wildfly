CDI example using Alternatives
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of *@Alternative* annotation with a CDI application

###### Build and Deploy
```shell
mvn clean install wildfly:deploy
```

###### Test
```shell
http://localhost:8080/javaee7-cdi-alternative
```

JSF ValidateWholeBean example
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates a JSF2.3 features which enables a centralized validation of all Bean properties using <f:validateWholeBean />

Requires JSF 2.3

###### Build and Deploy
```shell
mvn clean install wildfly:deploy
```

###### Test
```shell
http://localhost:8080/javaee8-jsf-validatewholebean
```

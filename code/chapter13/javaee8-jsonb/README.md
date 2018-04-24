Java EE 8 examples using JSON API
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of JSON-B API

###### Start a Java EE 8 profile
```shell
./standalone.sh -c standalone-ee8.xml  
```

###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/javaee8-jsonb/
```
 

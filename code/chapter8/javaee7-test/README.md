Arquillian example application
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates how to test a basic JPA application using Arquillian 

###### Build and Deploy
```shell
mvn clean install wildfly:deploy
```

###### Managed Test
```shell
mvn clean test -Parq-wildfly-managed
```

###### Remote Test
```shell
mvn clean test -Parq-wildfly-remote
```

###### Cloud Test (Requires setting up Openshift account + domain + application setup)
```shell
mvn clean test -Parquillian-openshift-express
```

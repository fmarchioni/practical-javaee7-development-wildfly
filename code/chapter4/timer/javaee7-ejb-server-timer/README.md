Timer EJB example
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the usage of Timer EJB 3 in a Java EE 7 Environment.

###### Create User

Add user to WildFly with this command: bin/add-user.sh -a -u ejbuser -p password123

###### Deploy
```shell
mvn clean install wildfly:deploy
```

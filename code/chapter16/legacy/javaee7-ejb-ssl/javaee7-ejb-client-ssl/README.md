Remote EJB Client SSL example
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the secure usage of a remote EJB application secured with SSL
###### Build and Deploy
```shell
mvn clean install exec:exec 
```
**Note** In order to run this example you need at first to generate Key pairs and install on the server. Next you have to configure the application server to use the https connector. Read through chapter 16 for information about it.
  

Basic JMS example
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of a remote JMS 2.0 client

###### Build Deploy and Test
```shell
mvn clean install test  
```
**Important Notice** If the javaee7-jms-basic example is running on your server, the receiver will fail to grab the message, that will be consumed by the MDB contained in javaee7-jms-basic. So undeploy at first the **javaee7-jms-basic** application using:
```shell
mvn clean install wildfly:undeploy  
```
###### WildFly 10 users
Note: If you are running WildFly 10 and above, you should update the its property in pom.xml:

```<version.wildfly>10.0.0.Final</version.wildfly>```

Thorntail Basic job example with Decision
=====================================

Example taken from [Practical Enterprise & Microservices development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Batch API with a with Decision class

###### Configure in the decision.xml file the FS Path to be scanned:
```xml
	<properties>
		<property name="filesystem" value="/home/francesco" />
	</properties>
```

###### Deploy
```shell
mvn clean thorntail:run
```
###### Test
```shell
http://localhost:8080 
```
 
 
 

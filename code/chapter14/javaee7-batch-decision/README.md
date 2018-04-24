Basic job example with Decision
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Batch API with a with Decision class

###### Configure in the decision.xml file the FS Path to be scanned:
```xml
	<properties>
		<property name="filesystem" value="/home/francesco" />
	</properties>
```

###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/javaee7-batch-decision/
```
 

Arquillian example application
=====================================
Example taken from [Practical Java EE 7 Development using WildFly application server](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates how to test a basic JPA application using Arquillian 

###### Build 
```shell
mvn clean install 
```

###### Managed Test

Configure src/test/resources/arquillian.xml in to point to your Wildfly installation. Ex:
```xml
	<configuration>
		<property name="jbossHome">/home/francesco/jboss/wildfly-12.0.0.Final</property>
		<property name="managementPort">9990</property>
		<property name="managementAddress">localhost</property>
	</configuration>
```
```shell
mvn test -Parq-wildfly-managed
```

###### Remote Test
```shell
mvn test -Parq-wildfly-remote
```


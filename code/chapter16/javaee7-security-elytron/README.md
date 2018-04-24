## Example of a secured Web application


1. You need to Define a Security Domain in your WildFly configuration matching with the information in jboss-web.xml: 
```xml
<jboss-web xmlns="http://www.jboss.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.jboss.org/schema/jbossas
    http://www.jboss.org/schema/jbossas/jboss-web_7_2.xsd">
 
   <security-domain>httpFsSD</security-domain> 
</jboss-web>
```
Check this CLI script to create an example FileSystem realm: https://github.com/fmarchioni/wildfly-admin-guide/blob/master/chapter15/fsrealm.cli

###### Compile and deploy

```shell
mvn clean install wildfly:deploy
```

Thorntail Keycloak Authentication
=====================================

Example taken from [Practical Enterprise & Microsevices development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates a Keycloak Authentication using Thorntail

###### Start Keycloak Server

```shell
./standalone.sh -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.file=./realm/realm-export.json -Dkeycloak.migration.strategy=OVERWRITE_EXISTING -Djboss.socket.binding.port-offset=100
```

###### Add User in Keycloak

Add one user belonging to 'Manager' Role.

###### Deploy
```shell
mvn clean thorntail:run
```
###### Test
```shell
http://localhost:8080 


 

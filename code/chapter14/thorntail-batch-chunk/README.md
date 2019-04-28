Thorntail Basic Chunk job example
=====================================

Example taken from [Practical Enterprise & Microsevices development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Batch API with a Chunk job example

###### Install the CSV file in the location specified by your simplejob.xml (in this example /tmp) 
```shell
cp input.csv /tmp
```
###### Deploy
```shell
mvn clean thorntail:run
```
###### Test
```shell
http://localhost:8080 
```
 
 



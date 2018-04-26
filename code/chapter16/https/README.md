Securing WildFly with SSL
=====================================

This folder contains the script generatekeys.sh to generate client/server keystores and trustores

###### Generate keys

```shell
./generatekeys.sh  
```

Then copy the keystores and trustores in the $JBOSS_HOME/standalone/configuration folder

```shell
cp *.keystore $JBOSS_HOME/standalone/configuration

cp *.truststore $JBOSS_HOME/standalone/configuration
```


###### Install keys on the application server

```shell
/bin/jboss-cli.sh --file=script.cli
```

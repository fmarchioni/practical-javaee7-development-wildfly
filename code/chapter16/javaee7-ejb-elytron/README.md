## Example how to invoke EJBs which are using a Security Domain

### Configure Elytron subsystem:

This is needed to configure elytron subsystem:
```shell
/bin/jboss-cli.sh --file=script.cli
```

### Compile and deploy the server application
```
cd server

mvn clean install wildfly:deploy
```

### Compile and execute the client application
```
cd client

mvn clean install exec:exec
```


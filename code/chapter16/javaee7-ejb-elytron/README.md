## Example how to invoke EJBs with EJB client over SSL/HTTPS (two-way authentication)

1. unzip EAP distro
2. copy `ssl/server.keystore` and `ssl/server.truststore` to `$EAP_HOME/standalone/configuration`
3. add user to EAP with this command:  `bin/add-user.sh -a -g users -u joe -p joeIsAwesome2013!`
4. prepare EAP config - there are two options

this is needed always:
```
/subsystem=elytron/key-store=server-key-store:add(path=server.keystore, relative-to=jboss.server.config.dir, credential-reference={clear-text=123456}, type=JKS)
/subsystem=elytron/key-store=server-trust-store:add(path=server.truststore, relative-to=jboss.server.config.dir, credential-reference={clear-text=123456}, type=JKS)
/subsystem=elytron/key-manager=example-key-manager:add(key-store=server-key-store, credential-reference={clear-text=123456})
/subsystem=elytron/trust-manager=example-trust-manager:add(key-store=server-trust-store)
/subsystem=elytron/server-ssl-context=example-ssl-context:add(trust-manager=example-trust-manager, key-manager=example-key-manager, need-client-auth=true, want-client-auth=true)
/subsystem=ejb3/application-security-domain=other:add(security-domain=ApplicationDomain)
 ```

option 1) to use https-remoting connector (port 8443):
```
batch
/subsystem=undertow/server=default-server/https-listener=https:undefine-attribute(name=security-realm)
/subsystem=undertow/server=default-server/https-listener=https:write-attribute(name=ssl-context,value=example-ssl-context)
run-batch
/subsystem=remoting/http-connector=https-remoting-connector:add(connector-ref=https, sasl-authentication-factory=application-sasl-authentication)
reload
```

option 2) to use bare remoting+ssl connector (port 4448):
```
/socket-binding-group=standard-sockets/socket-binding=remoting-ssl-sb:add(port=4448)
/subsystem=remoting/connector=remoting-ssl-connector:add(socket-binding=remoting-ssl-sb, sasl-authentication-factory=application-sasl-authentication, ssl-context=example-ssl-context)
/subsystem=ejb3/application-security-domain=other:add(security-domain=ApplicationDomain)
```

5. build server side, deploy
6. run client side using ```mvn exec:exec -Dremote.ejb.url=$URL```

default $URL is remote+https://127.0.0.1:8443



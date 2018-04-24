#!/bin/sh
# script for re-generating the keystores and truststores needed for SSL connector

# Create server keystore - file server.keystore
keytool -genkey -v -alias jbossalias -keyalg RSA -keysize 1024 -keystore server.keystore -validity 3650 -keypass 123456 -storepass 123456 -dname "cn=Server Administrator,o=Acme,c=GB" 

# Export Server's Public Key - file server.cer
keytool -export -keystore server.keystore -alias jbossalias -file server.cer -keypass 123456 -storepass 123456

# Export Client Key Store - file client.keystore
keytool -genkey -v -alias clientalias -keyalg RSA -keysize 1024 -keystore client.keystore -validity 3650 -keypass abcdef -storepass abcdef -dname "cn=Server Administrator,o=Acme,c=GB" 

# Exporting Client's Public Key - file client.cer
keytool -export -keystore client.keystore -alias clientalias -file client.cer -keypass abcdef -storepass abcdef

# Importing Client's Public key into server's truststore
keytool -import -v -trustcacerts -alias clientalias -file client.cer -keystore server.truststore -keypass 123456 -storepass 123456

# Importing Server's Public key into client's truststore
keytool -import -v -trustcacerts -alias jbossalias -file server.cer -keystore client.truststore -keypass abcdef -storepass abcdef

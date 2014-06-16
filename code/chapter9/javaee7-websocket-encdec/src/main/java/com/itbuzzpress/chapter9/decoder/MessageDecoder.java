package com.itbuzzpress.chapter9.decoder;


 
import java.io.StringReader;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import javax.xml.bind.*;

import com.itbuzzpress.chapter9.model.User;

public class MessageDecoder implements Decoder.Text<User> {
 
   public User decode(String s) {
       System.out.println("Incoming XML " + s);
       User person = null;
       JAXBContext jaxbContext;
       try {
           jaxbContext = JAXBContext.newInstance(User.class);
           Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
           StringReader reader = new StringReader(s);
           person = (User) unmarshaller.unmarshal(reader);
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return person;
   }
   
   public boolean willDecode(String s) {
	   // Determine if the message can be converted  
       return (s != null);
   }
   
   public void init(EndpointConfig endpointConfig) {
       // do nothing.
   }
   
   public void destroy() {
       // do nothing.
   }
}

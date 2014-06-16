package com.itbuzzpress.chapter9.encoder;


 
import java.io.StringWriter;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.itbuzzpress.chapter9.model.User;
 
public class MessageEncoder implements Encoder.Text<User> {
    public String encode(User object) throws EncodeException {
        JAXBContext jaxbContext = null;
        StringWriter st = null;
        try {
            jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            st = new StringWriter();
            marshaller.marshal(object, st);
            System.out.println("OutGoing XML " + st.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st.toString();
    }
    public void init(EndpointConfig endpointConfig) {
        // do nothing.
    }
    public void destroy() {
        // do nothing.
    }
}

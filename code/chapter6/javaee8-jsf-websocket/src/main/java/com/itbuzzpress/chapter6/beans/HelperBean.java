package com.itbuzzpress.chapter6.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class HelperBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(HelperBean.class.getName());

    @Inject
    @Push(channel ="hello")
    private PushContext push;

    public void random() {
    	Random rnd = new Random();
        int number = rnd.nextInt(100);
        String message = "Random number is " +number;
        LOG.log(Level.INFO, "Number: {0}", number);

        push.send(message);
    }

}

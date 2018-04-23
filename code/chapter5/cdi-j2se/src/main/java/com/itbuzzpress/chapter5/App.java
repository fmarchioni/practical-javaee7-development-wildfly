package com.itbuzzpress.chapter5;

import javax.enterprise.event.*;


public class App {
    public void onEvent(@Observes SimpleEvent ignored, SimpleService service) {
        service.greet();
    }
}

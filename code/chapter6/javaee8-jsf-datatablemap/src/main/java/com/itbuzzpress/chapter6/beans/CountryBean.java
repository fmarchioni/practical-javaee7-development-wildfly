package com.itbuzzpress.chapter6.beans;

import java.io.Serializable;
 
import java.text.SimpleDateFormat;
import java.util.HashMap;
 
import javax.faces.view.ViewScoped;
import javax.inject.Named;

 
@Named
@ViewScoped
public class CountryBean implements Serializable {

    HashMap<String, Country> map = new HashMap<>();
    final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); // not thread-safe, don't use it in production

    public CountryBean() {
        map.put("Italy", new Country("Rome","Europe","Italian",65000000));
        map.put("England", new Country("London","Europe","Italian",60000000));
        map.put("United States", new Country("Washington","America","Italian",325000000));
        map.put("Germany", new Country("Berlin","Europe","German",85000000));
    }
 

    public HashMap<String, Country> getMap() {
        return map;
    }
}

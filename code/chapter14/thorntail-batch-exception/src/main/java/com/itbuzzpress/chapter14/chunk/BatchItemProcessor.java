 
package com.itbuzzpress.chapter14.chunk;

import java.util.StringTokenizer;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;

 
@Named
public class BatchItemProcessor implements ItemProcessor {
   
    @Override
    public JsonObject processItem(Object t) {
        
        StringTokenizer tokens = new StringTokenizer((String)t, ",");

        String name = tokens.nextToken();
        String surname = tokens.nextToken();
        String age = tokens.nextToken();
        
        JsonObject model = Json.createObjectBuilder()
        		   .add("firstName", name)
        		   .add("lastName", surname)
        		   .add("age", age)
        		   .build();
        		   
        
        
        return model;
    }
}

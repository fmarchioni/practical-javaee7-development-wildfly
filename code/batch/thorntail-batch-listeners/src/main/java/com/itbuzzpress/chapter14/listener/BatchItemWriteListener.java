package com.itbuzzpress.chapter14.listener;

import java.util.List;

import javax.batch.api.chunk.listener.AbstractItemWriteListener;
import javax.inject.Named;

@Named
public class BatchItemWriteListener extends AbstractItemWriteListener {

    @Override
    public void beforeWrite(List items) throws Exception {
        
        System.out.println("BatchItemWriteListener.beforeWrite: " + items);
    }

    @Override
    public void afterWrite(List items) throws Exception {
        
        System.out.println("BatchItemWriteListener.afterWrite: " + items);
    }

    @Override
    public void onWriteError(List items, Exception ex) throws Exception {
        
        System.out.println("BatchItemWriteListener.onError: " + items + ", " + ex.getLocalizedMessage());
    }
}
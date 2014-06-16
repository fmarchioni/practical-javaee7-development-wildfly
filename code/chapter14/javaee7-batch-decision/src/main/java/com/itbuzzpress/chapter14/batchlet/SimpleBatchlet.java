
package com.itbuzzpress.chapter14.batchlet;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

import javax.batch.api.AbstractBatchlet;
import javax.batch.api.chunk.ItemProcessor;
import javax.batch.runtime.context.StepContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
@Named

public class SimpleBatchlet extends AbstractBatchlet {

	@Inject StepContext stepContext;

	@Override
	public String process() {
		System.out.println("Called SimpleBatchlet from step " +stepContext.getStepName());
		return "COMPLETED";
	}

}

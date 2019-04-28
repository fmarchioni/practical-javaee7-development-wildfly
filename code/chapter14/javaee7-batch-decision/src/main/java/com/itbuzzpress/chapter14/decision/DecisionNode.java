package com.itbuzzpress.chapter14.decision;

import java.io.File;
import java.util.Properties;

import javax.batch.api.Decider;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.StepExecution;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DecisionNode implements Decider {

	@Inject
	JobContext jobContext;

	@Override
	public String decide(StepExecution[] ses) throws Exception {
		Properties jobParameters = jobContext.getProperties();
		String fs = (String) jobParameters.get("filesystem");
 
		if (fs == null) {
			return "NOT_AVAILABLE";
		}
		
		File file = new File(fs);
		long totalSpace = file.getTotalSpace();
		if (totalSpace > 100000) {
			System.out.println("DecisionNode::Enough DiskSpace!");
			return "DSK_SPACE_OK";
		} else {
			System.out.println("DecisionNode::Not enough DiskSpace!");			
			return "DSK_SPACE_LOW";
		}	
	}

 
}
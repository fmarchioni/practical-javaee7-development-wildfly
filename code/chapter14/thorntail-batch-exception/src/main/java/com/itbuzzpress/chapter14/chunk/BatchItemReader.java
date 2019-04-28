 
package com.itbuzzpress.chapter14.chunk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

 
@Named
public class BatchItemReader extends AbstractItemReader {
	@Inject private JobContext jobContext; 
	
 
	private BufferedReader reader;

	@Override
	public void open(Serializable checkpoint) throws Exception {

		Properties jobParameters = jobContext.getProperties();
		
		String fileName = (String) jobParameters.get("input_file");

		reader = new BufferedReader(new FileReader(fileName));
	}

	@Override
	public String readItem() {
		try {
			String line = reader.readLine();
			return line;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}

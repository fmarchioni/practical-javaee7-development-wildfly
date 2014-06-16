package com.itbuzzpress.chapter14.chunk;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.JsonObject;
 


@Named
public class BatchItemWriter extends AbstractItemWriter {

	@Inject
	private JobContext jobContext; 

	@Override
	public void writeItems(List list) {

		String resourceName = (String) jobContext.getProperties().get("output_file");

		try(PrintWriter pw =new PrintWriter(new FileWriter(resourceName,true))){

			for (Object json: list) {
				System.out.println("Writer "+((JsonObject)json).toString());
				pw.write(((JsonObject)json).toString());
			}
			pw.flush();

		}catch (Exception e){
			System.err.println("Error: " + e);
		}
	}
}


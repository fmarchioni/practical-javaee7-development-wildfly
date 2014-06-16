package com.itbuzzpress.chapter3.servlet.async;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class ExampleReadListener implements ReadListener {
	private ServletInputStream is = null;
	private AsyncContext async = null;

	public ExampleReadListener(ServletInputStream input,
			AsyncContext asyncCtx) {
		this.is = input;
		this.async = asyncCtx;
	}
	@Override
	public void onDataAvailable() {
		try {
			async.getResponse().getWriter()
			.write("Some data available!\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			StringBuilder sb = new StringBuilder();
			int len = -1;
			byte b[] = new byte[1024];

			while (is.isReady()
					&& (len = is.read(b)) != -1) {

				String data = new String(b, 0, len);
				async.getResponse().getWriter()
				.write(data);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void onAllDataRead() {

		try {
			async.getResponse().getWriter()
			.write("\nAll data has been read!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		async.complete();
	}
	@Override
	public void onError(Throwable thrwbl) {
		System.out.println("Error: " + thrwbl);
		async.complete();
	}



}

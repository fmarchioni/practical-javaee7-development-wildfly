

package com.itbuzzpress.chapter14.listener;

import java.util.List;

import javax.batch.api.chunk.listener.SkipWriteListener;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.itbuzzpress.chapter14.exception.IllegalItemException;

@Named
public class ChunkSkipWriteListener implements SkipWriteListener {
	@Inject
	JobContext jobContext;

	@Override
	public void onSkipWriteItem(List list, Exception e) throws Exception {
		 if (e instanceof IllegalItemException) {
			int item = ((IllegalItemException) e).getItem();
			list.remove(item);
			System.out.println("Purged illegal item from the list! "+item);
		} 

		System.out.println("MySkipWriteListener.onSkipWriteItem: "
						+ list + ", " + e.getMessage());

	}

}

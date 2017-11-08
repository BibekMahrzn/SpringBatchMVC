package com.me;

import com.me.model.Report2;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor2 implements ItemProcessor<Report2, Report2> {

	@Override
	public Report2 process(Report2 item) throws Exception {
		
		System.out.println("Processing..." + item);
		return item;
	}

}
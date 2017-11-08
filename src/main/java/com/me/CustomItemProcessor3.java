package com.me;

import com.me.model.Report;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor3 implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {
		
		System.out.println("Processing..." + item);
		return item;
	}

}
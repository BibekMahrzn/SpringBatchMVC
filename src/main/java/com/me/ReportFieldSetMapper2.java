package com.me;

import com.me.model.Report2;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ReportFieldSetMapper2 implements FieldSetMapper<Report2> {

//	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Report2 mapFieldSet(FieldSet fieldSet) throws BindException {

		Report2 report = new Report2();
		report.setDate(fieldSet.readString(0));
		report.setClicks(fieldSet.readString(2));
		report.setEarning(fieldSet.readString(3));
		report.setImpressions(fieldSet.readString(1));

		//default format yyyy-MM-dd
		//fieldSet.readDate(4);
//		String date = fieldSet.readString(4);
//		report.setDate(date);
//		try {
//			report.setDate(dateFormat.parse(date));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

		return report;
		
	}

}
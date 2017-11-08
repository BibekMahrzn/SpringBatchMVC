package com.me;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		String[] springConfig  = 
			{	
				"spring/batch/jobs/job-hello-world.xml" 
			};
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("helloWorldJob");

		try {
//			JobParameters jobParameters =
//					new JobParametersBuilder()
//							.addLong("time",System.currentTimeMillis())
//							.addString("date","08-SEP-17 12.00.00.000000000 AM").toJobParameters();
//							addString("age", "20").toJobParameters();
//			JobParameters param = new JobParametersBuilder().addString("age", "20").toJobParameters();
			JobParameters jobParameters =
					new JobParametersBuilder()
							.addLong("time",System.currentTimeMillis()).toJobParameters();
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}

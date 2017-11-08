package com.me;

import com.me.model.Candidate;
import org.springframework.batch.item.ItemProcessor;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class CustomItemProcessor4 implements ItemProcessor<Candidate, Candidate> {

	@Override
	public Candidate process(Candidate item) throws Exception {

		System.out.println("Processing..." + item.getMobileNO());
		String advtcode=item.getAvtCode();
		String msg = "Your%20payment%20has%20been%20received%20for%20AdvertisementCode%20"+advtcode+"%20PSC%20NEPAL";
		String requestUrl="http://api.sparrowsms.com/v2/sms/?token=eQAot7Q1q4eVPkuiESVA&from=PSC&to="+item.getMobileNO()+"&text="+msg;
		URL url = new URL(requestUrl);
		HttpURLConnection uc = (HttpURLConnection)url.openConnection();
		if(uc.getResponseMessage().equals("OK")){
			System.out.println("Status => "+uc.getResponseMessage());
		}else{
			System.out.println("Status => "+uc.getResponseMessage());
//			throw new Exception();
		}
		return item;
	}

}
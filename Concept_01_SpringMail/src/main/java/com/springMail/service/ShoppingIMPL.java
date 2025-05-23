package com.springMail.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service("shopping")
public class ShoppingIMPL implements IShopping {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("$spring.mail.username=saikumarlaveti5061@gmail.com")
	private String fromMail;

	@Override
	public String purchase(String[] items, float[] prices, String[] toMails) throws Exception {
		System.out.println("ShoppingIMPL.purchase()");
		float billAmt = 0.0f;
		
		for(float p:prices) {
			billAmt = billAmt+p;
		}
		
		String message = "The Items "+Arrays.toString(items)+"with prices"
				+Arrays.toString(prices)+"are purchased having bill amount:: "+billAmt;
		String status = sendMail(message,"shopping details",toMails);
		return message;
		
	}
	
	private String sendMail(String body,String subject,String[] tomails) throws Exception {
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setFrom(fromMail);
		helper.setCc(tomails);
		helper.setSubject(subject);
		helper.setSentDate(new Date());
		helper.setText(body);
		helper.addAttachment("404.jpeg", new ClassPathResource("404.jpeg"));
		sender.send(message);
		return "mail with attachment is sent";
		
	}

}

package com.gy612.loan.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gy612.loan.dto.RegisterUserResult;
import com.gy612.loan.exception.MailAddrException;



/**
 * 邮件工具类
 * @author K550J
 *
 */
public class MailUtils {
	
	private static Properties data=new Properties();
	private static Properties prop;
	
	//@Value("${name}")
	private static String username="13533070038";
	//@Value("${authorizationCode}")
	private static String authorizationCode="19951022ZHU";
	//@Value("${emailAddr}")
	private static String myAddress="13533070038@163.com";
	//@Value("${hostProtocol}")
	private static String hostProtocol="smtp";
	//@Value("${hostUrl}")
	private static String hostUrl="smtp.163.com";
	//@Value("${hostPort}")
	private static String hostPort="25";
	
	static Session session ;
	
	static{
		
//		InputStream file;
//		try {
//			file = new FileInputStream("mail.properties");
//			data.load(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		username =  data.getProperty("name");
//		authorizationCode = data.getProperty("authorizationCode");
//		myAddress = data.getProperty("emailAddr");
		
//		System.out.println(username+"--"+authorizationCode+"--"+myAddress);
		
		prop = new Properties();
		
		/*步骤一:设置配置信息*/
		prop.setProperty("mail.smtp.auth","true" ); //设置认证(当作为客户端时需要为true)
		prop.setProperty("mail.transport.protocol",hostProtocol);
		prop.setProperty("mail.smtp.host", hostUrl);
		prop.setProperty("mail.smtp.port", hostPort); 
		
	}
	
	public static RegisterUserResult sendCheckMail(RegisterUserResult user){
		
		System.out.println(username+"--"+authorizationCode+"--"+myAddress+"--"+hostProtocol+"--"+hostUrl+"--"+hostPort);
		
		session = Session.getInstance(prop,new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,authorizationCode);
			}
		});
		Message message = new MimeMessage(session);
		try {
			message.setSubject("借贷系统邮箱验证");
			message.setText("欢迎注册借贷系统，这是您的邮箱激活码:"+user.getMailCheckCode());
			message.setFrom(new InternetAddress(myAddress));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(user.getData().getUsermail()));
			
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			//user.setSuccess(false);
			//user.setErrorMessage("邮箱不存在，发送验证失败 ");
			throw new MailAddrException("邮箱地址不存在");
		}
		
		return user;
	}

}

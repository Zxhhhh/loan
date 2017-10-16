package com.gy612.loan.utils;

import java.util.Random;
import java.util.UUID;


/**
 * 生成UUID
 * @author K550J
 *
 */
public class NumUtils {
	
	//盐值大小
	public static final Integer SALT_SIZE = 9;
	
	//邮箱验证码大小
	public static final Integer CHECK_SIZE = 6;
	
	
	/**
	 * 生成UUID主键
	 * @return
	 */
	public static String createId(){
		
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-","");
		return id;
	}
	
	/**
	 * 生成盐值
	 * @return
	 */
	public static String createSlat(){
		StringBuilder saltBuilder = new StringBuilder();
		Random random = new Random();
		String codes = "123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
		for(int i=0;i<SALT_SIZE;i++){
			int index = random.nextInt(codes.length());
			saltBuilder.append(codes.charAt(index));
		}
		return saltBuilder.toString();
	}
	
	/**
	 * 生成邮箱验证码
	 * @return
	 */
	public static Integer createMailCheckCode(){
		StringBuilder codeBuilder = new StringBuilder();
		Random random = new Random();
		String codes = "123456789";
		for(int i=0;i<SALT_SIZE;i++){
			int index = random.nextInt(codes.length());
			codeBuilder.append(codes.charAt(index));
		}
		Integer mailCheckCode = Integer.parseInt(codeBuilder.toString()); 
		return mailCheckCode;
	}
	
	public static void main(String[] args) {
			
		System.out.println(createSlat());
	
	}
}

package com.springMail.service;

public interface IShopping {

	public String purchase(String[] items,float[] prices, String[] toMail) throws Exception;
}

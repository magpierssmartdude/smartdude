package com.smartdude.utility;

public class SmartDudeUtilityService {

	
	public static String getUser() {
		return "";
	}
	
	public static String buildTemPassword(String username,String mobnumber,String orgName) {
		
		return username.substring(0,2)+mobnumber.substring(0,2)+orgName.substring(0,2);
	}
}

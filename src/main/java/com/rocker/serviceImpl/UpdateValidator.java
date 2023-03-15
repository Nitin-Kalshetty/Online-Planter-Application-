package com.rocker.serviceImpl;

public class UpdateValidator {

	public  boolean checker(String str) {
		if(str.equals("") || str.startsWith(" ") || str==null) {
			return false;
		}
		return true;
	}
	public boolean checker(Integer id) {
		if(id<=0 ) {
			return false;
		}
		return true;
	}
	public  boolean checker(Double id) {
		if(id<=0 ) {
			return false;
		}
		return true;
	}
}

package com.diatoz.college.model;


public class ErrorDetail {
	
	
	private String Error;
	private String Errordetails;
	
	public ErrorDetail(String error, String errordetails) {
		super();
		Error = error;
		Errordetails = errordetails;
	}
	
	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	public String getErrordetails() {
		return Errordetails;
	}

	public void setErrordetails(String errordetails) {
		Errordetails = errordetails;
	}
	
	
}

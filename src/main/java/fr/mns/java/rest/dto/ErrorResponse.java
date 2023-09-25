package fr.mns.java.rest.dto;


public class ErrorResponse {
	private int responseCode; 
	private String errorMessage;
	
	//getter setter
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}

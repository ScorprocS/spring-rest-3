package fr.mns.java.rest.exception;

/**
 * The Class InvalidParameterException.
 */
public class InvalidParameterException extends Exception{

	public InvalidParameterException(String params) {
		super("Invalid parameters " + params);
	}

	
}

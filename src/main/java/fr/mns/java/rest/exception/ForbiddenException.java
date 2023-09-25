package fr.mns.java.rest.exception;

/**
 * The Class ForbiddenException.
 */
public class ForbiddenException extends Exception {
	
	/**
	 * Instantiates a new forbidden exception.
	 */
	public ForbiddenException() {
		super("User can not access to this ressources");
	}
	

}

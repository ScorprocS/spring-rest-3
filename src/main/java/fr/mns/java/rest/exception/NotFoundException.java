package fr.mns.java.rest.exception;

/**
 * The Class NotFoundException.
 */
public class NotFoundException extends Exception {
	
	public NotFoundException(Long id) {
		super("Entity "+id+" not found");
	}

}

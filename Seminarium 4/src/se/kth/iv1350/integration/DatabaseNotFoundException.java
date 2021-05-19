package se.kth.iv1350.integration;

/**
 * Thrown when a database can not be reached
 * 
 * @author Andreas Nyström
 *
 */

public class DatabaseNotFoundException extends Exception{
	
	public DatabaseNotFoundException(String message) {
		super(message);
	}

}

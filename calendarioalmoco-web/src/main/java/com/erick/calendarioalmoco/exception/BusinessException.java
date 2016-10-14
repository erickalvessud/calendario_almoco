package com.erick.calendarioalmoco.exception;

/**
 * Class that represents a exceptional business rule violation case or error.
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.
	 * @param message - Message to be display to the client.
	 */
	public BusinessException(String message){
		super(message);
	}
}
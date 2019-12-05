package org.wahlzeit.exceptions;

import java.util.logging.Logger;

public class IllegalDistanceException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger("IllegalDistanceException");
	
	public IllegalDistanceException() {
		super();
	}
	
	public IllegalDistanceException(double distance) {
		log.info("Illegal Distance detected. Distance should not be Negative");
	}
}

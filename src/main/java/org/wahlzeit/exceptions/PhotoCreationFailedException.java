package org.wahlzeit.exceptions;

import java.util.logging.Logger;

public class PhotoCreationFailedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger("PhotoCreationFailedException");
	
	public PhotoCreationFailedException() {
		super();
	}
	
	public PhotoCreationFailedException(String errormessage) {
		log.info("Photo Creation has failed:" +errormessage);
	}

}

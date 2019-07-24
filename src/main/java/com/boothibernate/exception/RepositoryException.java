package com.boothibernate.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boothibernate.model.Response;

public class RepositoryException extends RuntimeException {

	private Response response;

	private String message;

	private Logger logger = LoggerFactory.getLogger(RepositoryException.class.toString());

	public RepositoryException(Exception e) {
		super(e);
		logger.debug("Error Occurred \n logging the exception " + e.getMessage());
		this.message = e.getMessage();
	}

	public Response getResponse() {
		if (null == response) {
			this.response = new Response(500, "The following error cause the operation to fail" + this.message);
		}
		return this.response;
	}

}

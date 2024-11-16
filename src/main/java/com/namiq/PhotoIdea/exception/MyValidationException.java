package com.namiq.PhotoIdea.exception;

import org.springframework.validation.BindingResult;

public class MyValidationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BindingResult result;

	public BindingResult getResult() {
		return result;
	}

	public MyValidationException(BindingResult result) {
		this.result = result;
	}

}

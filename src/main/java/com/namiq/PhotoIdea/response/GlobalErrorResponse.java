package com.namiq.PhotoIdea.response;

import java.util.List;

import lombok.Data;

@Data
public class GlobalErrorResponse {
	private Integer code;
	private String message;
	private String internalMessage;

	private List<ValidationErrorModel> validations;

}

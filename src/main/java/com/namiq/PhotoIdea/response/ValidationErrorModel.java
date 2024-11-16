package com.namiq.PhotoIdea.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorModel {
	private String field;
	private String message;

}

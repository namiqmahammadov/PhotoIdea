package com.namiq.PhotoIdea.advice;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.namiq.PhotoIdea.exception.CustomerNotFoundException;
import com.namiq.PhotoIdea.exception.DuplicateCustomerException;
import com.namiq.PhotoIdea.exception.MyValidationException;
import com.namiq.PhotoIdea.response.GlobalErrorResponse;
import com.namiq.PhotoIdea.response.ValidationErrorModel;





@RestControllerAdvice
public class GlobalExceptionHandler {
	GlobalErrorResponse res=new GlobalErrorResponse();
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public GlobalErrorResponse handleMyValidationException(MyValidationException exc) {
	
		
		res.setInternalMessage("data is not full");
		res.setMessage("Melumatlarin tamliginda problem  var");
		res.setCode(400);
		BindingResult bindingResult = exc.getResult();
		ArrayList<ValidationErrorModel> errors = new ArrayList<>();
		for (FieldError err : bindingResult.getFieldErrors()) {
		errors.add(new ValidationErrorModel(err.getField(),err.getDefaultMessage()));
		
		}
		return res;
		}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public GlobalErrorResponse handelCustomerNotFoundException(CustomerNotFoundException exc) {
		
		res.setInternalMessage("Customer not found");
		res.setMessage("Musteri tapilmadi");
		res.setCode(404);
		return res;
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public GlobalErrorResponse handelDuplicateCustomerException(DuplicateCustomerException exc) {
		
		res.setInternalMessage("Customer with this email already exists ");
		res.setMessage("Bu email ilə müştəri artıq mövcuddur");
		res.setCode(404);
		return res;
	}
}

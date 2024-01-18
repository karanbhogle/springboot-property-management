package net.karanbhogle.springbootproject.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ProjectExceptionHandler {
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex) {
		logger.log(Level.ALL, "Business Exception occurred");
		return new ResponseEntity<>(bex.getErrors(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv) {
		List<ErrorModel> errorModelList = new ArrayList<>();
		ErrorModel errorModel;
		List<FieldError> fieldErrorList = manv.getBindingResult().getFieldErrors();
		
		for(FieldError fe: fieldErrorList) {
			errorModel = new ErrorModel();
			errorModel.setCode(fe.getField());
			errorModel.setMessage(fe.getDefaultMessage());
			errorModelList.add(errorModel);
		}
		
		return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
	}
}

package net.karanbhogle.springbootproject.utils;

import java.util.ArrayList;
import java.util.List;

import net.karanbhogle.springbootproject.exception.ErrorModel;

public class MessageHelper {
	private MessageHelper() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static List<ErrorModel> getErrorMessageList(String code, String message) {
		List<ErrorModel> errorModelList = new ArrayList<>();
		
		ErrorModel errorModel = new ErrorModel();
		errorModel.setCode(code);
		errorModel.setMessage(message);
		errorModelList.add(errorModel);
		return errorModelList;
	}
}

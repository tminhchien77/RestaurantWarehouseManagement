package com.hdv.api.validation;

import com.hdv.api.entities.request.PostAccountPayLoad;

public class ModelValidationHelper {

	public static void validate(PostAccountPayLoad request) throws Exception {
        if (request == null) {
            throw new Exception("requestBodyIsNull,storeIdCannotBeNull");
        }
        // example
        if (request.getUser().getName().trim().isEmpty() || request.getUser().getName()==null){
            throw new Exception("NameCannotBeNull");
        }
	}
	
}

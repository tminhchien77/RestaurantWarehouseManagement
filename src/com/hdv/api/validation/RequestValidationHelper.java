package com.hdv.api.validation;

import com.hdv.api.entities.request.PostAccountPayLoad;

public class RequestValidationHelper {

    @SuppressWarnings("null")
    public static void validateRequest(PostAccountPayLoad request) throws Exception {
       ModelValidationHelper.validate(request);
    }

}


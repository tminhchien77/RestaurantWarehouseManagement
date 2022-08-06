package com.rwm.api.validation;

import com.rwm.api.entities.request.PostAccountPayLoad;

public class RequestValidationHelper {

    @SuppressWarnings("null")
    public static void validateRequest(PostAccountPayLoad request) throws Exception {
       ModelValidationHelper.validate(request);
    }

}


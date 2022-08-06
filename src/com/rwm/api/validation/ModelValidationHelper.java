package com.rwm.api.validation;

import com.rwm.api.entities.request.PostAccountPayLoad;
import com.rwm.api.utils.Const;


public class ModelValidationHelper {

	public static void validate(PostAccountPayLoad request) throws Exception {
        if (request == null) {
            throw new Exception("requestBodyIsNull,storeIdCannotBeNull");
        }
        boolean kt = request.getPhone().matches(Const.regPhone);
        if (!kt) {
            throw new Exception("Phone is not illegal");
        }
        kt=request.getEmail().trim().matches(Const.regEmail);
        if (!kt) {
            throw new Exception("Email is not illegal");
        }
        if (request.getName().trim().isEmpty() || request.getName()==null){
            throw new Exception("NameCannotBeNull");
        }
        if (request.getPassword()==null || request.getPassword().trim().isEmpty() ){
            throw new Exception("PasswordCannotBeNull");
        }
        if (request.getAddress()==null){
            throw new Exception("AddressCannotBeNull");
        }
        if (request.getIdRole()==null){
            throw new Exception("IDRoleCannotBeNull");
        }
	}
	
}

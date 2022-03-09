package com.hdv.api.validation;

import com.hdv.api.entities.request.PostAccountPayLoad;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class ModelValidationHelperTest {

    @Test
    public void validate() {
        String regPhone = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String regEmail="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String phone="0977234543";
        String email="doan@gmail.com";
        boolean kt = phone.matches(regPhone);
        boolean kt1 = email.matches(regEmail);
        assertTrue(kt);
        assertTrue(kt1);
    }
}
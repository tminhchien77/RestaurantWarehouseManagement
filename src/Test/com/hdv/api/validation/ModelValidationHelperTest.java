package com.hdv.api.validation;

import com.google.gson.JsonObject;
import com.hdv.api.entities.request.PostAccountPayLoad;
import com.hdv.api.resources.MRes;
import com.hdv.api.utils.JsonUtil;
import com.hdv.api.utils.OBJ;
import com.hdv.api.validation.jwt.JWTConfig;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class ModelValidationHelperTest {

    @Test
    public void validate() throws Exception {
        String regPhone = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String regEmail="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String phone="0977234543";
        String email="doan@gmail.com";
        boolean kt = phone.matches(regPhone);
        boolean kt1 = email.matches(regEmail);
        assertTrue(kt);
        assertTrue(kt1);
        String key="{\"key\":\"HDV2022Secret\"}";
        System.out.println(key);
        String zipTest= OBJ.zip(key);
        System.out.println("zip test: "+zipTest);
        String k1=String.valueOf(OBJ.unZip(zipTest));
        System.out.println(k1);
        JsonObject json1 = JsonUtil.gson.fromJson(k1,
                JsonObject.class);
        System.out.println(json1);
        System.out.println(json1.get("key").getAsString());

        System.out.println(JWTConfig.ins().key);

    }


    //	public static final String key="HDV2022Secret";

    //token gen :
    // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJEb2FuQ3VvbmdEYWkiLCJuYW1lIjoiSERWIEdyb3VwIiwiaWF0IjoyNTAxMjAyMjA5MTE3MTE5MDB9.2VaeS_V11otO0TX6P1w9eIPQQKtlNHbGfUoS55AzkGg

}
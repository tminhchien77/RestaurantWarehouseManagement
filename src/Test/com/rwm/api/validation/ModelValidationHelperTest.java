package Test.com.rwm.api.validation;

import org.junit.Test;

public class ModelValidationHelperTest {

    @Test
    public void validate() throws Exception {
        String regPhone = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[2689])|(7[06-9])|(8[1-9])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String reg1="^(0|\\+84)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String phone="0 123 456 789";
        boolean kt = phone.matches(reg1);
       //assertTrue(kt);



        String regEmail="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";


        String json="{\n  \"response\": \"{\\\"Success\\\":true,\\\"Data\\\":{\\\"data\\\":{\\\"greedy_search_output\\\":\\\"cá cam tươi\\\",\\\"beam_search_output\\\":\\\"cá cam tươi\\\",\\\"ds_sanpham\\\":[{\\\"id\\\":\\\"9932851000011\\\",\\\"sanpham\\\":\\\"Cá Cam Tươi\\\",\\\"score\\\":\\\"100.0\\\"},{\\\"id\\\":\\\"9934286000050\\\",\\\"sanpham\\\":\\\"CÁ CAM KHO \\\",\\\"score\\\":\\\"57.208\\\"},{\\\"id\\\":\\\"9933019000305\\\",\\\"sanpham\\\":\\\"CÁ CAM SC\\\",\\\"score\\\":\\\"50.175\\\"}]},\\\"processing_time\\\":1.5887882709503174},\\\"Message\\\":\\\"\\\",\\\"Status\\\":\\\"\\\"}\",\n  \"choose\": \"{\\\"id\\\":\\\"9932851000011\\\", \\\"sanpham\\\":\\\"Cá Cam Tươi\\\", \\\"score\\\":\\\"100.0\\\"}\"\n}";
        json=json.replaceAll("\\\\\"", "\"");
        System.out.println(json);
       // String email="doan@gmail.com";
       // boolean kt1 = email.matches(regEmail);
      //  assertTrue(kt1);
//        String key="{\"key\":\"HDV2022Secret\"}";
//        System.out.println(key);
//        String zipTest= OBJ.zip(key);
//        System.out.println("zip test: "+zipTest);
//        String k1=String.valueOf(OBJ.unZip(zipTest));
//        System.out.println(k1);
//        JsonObject json1 = JsonUtil.gson.fromJson(k1,
//                JsonObject.class);
//        System.out.println(json1);
//        System.out.println(json1.get("key").getAsString());
//
//        System.out.println(JWTConfig.ins().key);

    }


    //	public static final String key="HDV2022Secret";

    //token gen :
    // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJEb2FuQ3VvbmdEYWkiLCJuYW1lIjoiSERWIEdyb3VwIiwiaWF0IjoyNTAxMjAyMjA5MTE3MTE5MDB9.2VaeS_V11otO0TX6P1w9eIPQQKtlNHbGfUoS55AzkGg

}
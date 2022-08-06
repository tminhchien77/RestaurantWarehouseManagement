package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.PostAccountPayLoad;
import com.rwm.api.entities.response.PostAccountResponseData;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.AccountService;
import com.rwm.api.utils.Global;
import com.rwm.api.validation.RequestValidationHelper;

import java.util.TimeZone;

public class PostAccountHandler extends APIHandler<PostAccountPayLoad, PostAccountResponseData> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public PostAccountHandler() {
        super(PostAccountPayLoad.class);
    }

    @Override
    protected PostAccountResponseData handle(PostAccountPayLoad request) throws Exception {
       // bước 1: validate payload
        RequestValidationHelper.validateRequest(request);
        //bước 2: thực hiện service
        AccountService.createAccount(request);
        //bước 3: trả message
        PostAccountResponseData response = new PostAccountResponseData();
        I18n.load(Global.locale);
        String message = I18n.get("postAccountSuccess");
        response.setMessage(message);
        return response;
    }
}

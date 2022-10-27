package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.PostAccountPayLoad;
import com.rwm.api.entities.request.PostItemSupsPayLoad;
import com.rwm.api.entities.response.PostAccountResponseData;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.AccountService;
import com.rwm.api.service.ItemService;
import com.rwm.api.utils.Global;
import com.rwm.api.validation.RequestValidationHelper;

import java.util.TimeZone;

public class PostItemSupsHandler extends APIHandler<PostItemSupsPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public PostItemSupsHandler() {
        super(PostItemSupsPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(PostItemSupsPayLoad request) throws Exception {
        ItemService.addItemSups(request);
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("postAccountSuccess");
        response.setMessage(message);
        return response;
    }
}

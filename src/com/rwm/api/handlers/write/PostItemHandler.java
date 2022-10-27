package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.PostAccountPayLoad;
import com.rwm.api.entities.request.PostItemPayLoad;
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

public class PostItemHandler extends APIHandler<PostItemPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public PostItemHandler() {
        super(PostItemPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(PostItemPayLoad request) throws Exception {
        ItemService.addItem(request);
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("postItemSuccess");
        response.setMessage(message);
        return response;
    }
}

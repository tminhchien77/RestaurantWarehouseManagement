package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.PostImExRequestPayLoad;
import com.rwm.api.entities.request.PostItemSupsPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.ImExRequestService;
import com.rwm.api.service.ItemService;
import com.rwm.api.utils.Global;

import java.util.TimeZone;

public class PostImExRequestHandler extends APIHandler<PostImExRequestPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public PostImExRequestHandler() {
        super(PostImExRequestPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(PostImExRequestPayLoad request) throws Exception {
        ImExRequestService.addImExRequest(request);
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("postImExRequestSuccess");
        response.setMessage(message);
        return response;
    }
}

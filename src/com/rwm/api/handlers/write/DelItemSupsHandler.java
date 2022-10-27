package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.DeleteItemSupsPayLoad;
import com.rwm.api.entities.request.PostItemPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.ItemService;
import com.rwm.api.utils.Global;

import java.util.TimeZone;

public class DelItemSupsHandler extends APIHandler<DeleteItemSupsPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public DelItemSupsHandler() {
        super(DeleteItemSupsPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(DeleteItemSupsPayLoad request) throws Exception {
        ItemService.delItemSups(request);
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("deleteItemSupsSuccess");
        response.setMessage(message);
        return response;
    }
}

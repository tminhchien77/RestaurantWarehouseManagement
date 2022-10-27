package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.DeleteItemSupsPayLoad;
import com.rwm.api.entities.request.IntPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.ItemService;
import com.rwm.api.utils.Global;

import java.util.TimeZone;

public class DelItemHandler extends APIHandler<IntPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public DelItemHandler() {
        super(IntPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(IntPayLoad request) throws Exception {
        ItemService.delItem(request);
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("deleteItemSuccess");
        response.setMessage(message);
        return response;
    }
}

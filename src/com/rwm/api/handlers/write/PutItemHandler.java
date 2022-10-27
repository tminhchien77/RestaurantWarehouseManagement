package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.PostItemPayLoad;
import com.rwm.api.entities.request.PutItemPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.ItemService;
import com.rwm.api.utils.Global;

import java.util.TimeZone;

public class PutItemHandler extends APIHandler<PutItemPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public PutItemHandler() {
        super(PutItemPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(PutItemPayLoad request) throws Exception {
        //bước 2: thực hiện service
        ItemService.updItem(request);
        //bước 3: trả message
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("putItemSuccess");
        response.setMessage(message);
        return response;
    }
}

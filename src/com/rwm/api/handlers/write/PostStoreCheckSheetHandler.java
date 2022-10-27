package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.PostStoreCheckSheetPayLoad;
import com.rwm.api.entities.request.PostSupplierPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.StoreCheckSheetService;
import com.rwm.api.service.SupplierService;
import com.rwm.api.utils.Global;

import java.util.TimeZone;

public class PostStoreCheckSheetHandler extends APIHandler<PostStoreCheckSheetPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public PostStoreCheckSheetHandler() {
        super(PostStoreCheckSheetPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(PostStoreCheckSheetPayLoad request) throws Exception {
        StoreCheckSheetService.addStoreCheckSheet(request);
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("postStoreCheckSheetSuccess");
        response.setMessage(message);
        return response;
    }
}

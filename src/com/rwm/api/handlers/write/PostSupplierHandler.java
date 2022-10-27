package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.PostItemPayLoad;
import com.rwm.api.entities.request.PostSupplierPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.ItemService;
import com.rwm.api.service.SupplierService;
import com.rwm.api.utils.Global;

import java.util.TimeZone;

public class PostSupplierHandler extends APIHandler<PostSupplierPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public PostSupplierHandler() {
        super(PostSupplierPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(PostSupplierPayLoad request) throws Exception {
        SupplierService.addSupplier(request);
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("postSupplierSuccess");
        response.setMessage(message);
        return response;
    }
}

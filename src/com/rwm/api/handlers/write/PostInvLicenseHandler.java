package com.rwm.api.handlers.write;

import com.rwm.api.entities.request.PostInvLicensePayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.InvLicenseService;
import com.rwm.api.utils.Global;

import java.util.TimeZone;

public class PostInvLicenseHandler extends APIHandler<PostInvLicensePayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public PostInvLicenseHandler() {
        super(PostInvLicensePayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(PostInvLicensePayLoad request) throws Exception {
        InvLicenseService.addInvLicense(request);
        ResponseDataWithObject response = new ResponseDataWithObject();
        I18n.load(Global.locale);
        String message = I18n.get("postItemSuccess");
        response.setMessage(message);
        return response;
    }
}

package com.rwm.api.handlers.read;


import com.rwm.api.entities.APIRequest;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.InvLicenseService;
import com.rwm.api.utils.Global;

import java.util.TimeZone;

public class GetInvLicenseIdHandler extends APIHandler<APIRequest, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetInvLicenseIdHandler() {
        super(APIRequest.class);
    }

    @Override
    protected ResponseDataWithObject handle(APIRequest request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        String invoiceLicenseId = InvLicenseService.getInvoiceLicenseId();
        response.setData(invoiceLicenseId);
        I18n.load(Global.locale);
        String message = I18n.get("getInvoiceLicenseIdSuccess");
        response.setMessage(message);
        return response;

    }
}

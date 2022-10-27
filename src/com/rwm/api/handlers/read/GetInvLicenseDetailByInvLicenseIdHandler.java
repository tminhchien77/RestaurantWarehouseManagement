package com.rwm.api.handlers.read;


import com.rwm.api.dbresult.RGetInvLicenseDetailByInvLicenseId;
import com.rwm.api.dbresult.RGetItemSupsBySupplierId;
import com.rwm.api.entities.request.GetByUidPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.InvLicenseService;
import com.rwm.api.service.ItemSupService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GetInvLicenseDetailByInvLicenseIdHandler extends APIHandler<GetByUidPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetInvLicenseDetailByInvLicenseIdHandler() {
        super(GetByUidPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(GetByUidPayLoad request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<RGetInvLicenseDetailByInvLicenseId> listQuery = new ArrayList<>();
        listQuery = InvLicenseService.getInvLicenseDetailByInvLicenseId(request);
        List<Map<String,Object>> data = listQuery.stream().map(RGetInvLicenseDetailByInvLicenseId::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getInvLicenseDetailByInvLicenseIdSuccess");
        response.setMessage(message);
        return response;

    }
}

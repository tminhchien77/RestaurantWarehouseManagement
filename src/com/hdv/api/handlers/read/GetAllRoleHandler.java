package com.hdv.api.handlers.read;



import com.hdv.api.dbresult.RGetRole;
import com.hdv.api.entities.APIRequest;
import com.hdv.api.entities.response.GetAllRoleResponseData;
import com.hdv.api.handlers.APIHandler;
import com.hdv.api.resources.I18n;
import com.hdv.api.posclient.Global;
import com.hdv.api.service.RoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GetAllRoleHandler extends APIHandler<APIRequest, GetAllRoleResponseData> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetAllRoleHandler() {
        super(APIRequest.class);
    }

    @Override
    protected GetAllRoleResponseData handle(APIRequest request) throws Exception {
       // RequestValidationHelper.validateOutputVoucherDetail4kForDelivery(request);
        GetAllRoleResponseData response = new GetAllRoleResponseData();

        List<RGetRole> listQuery = new ArrayList<>();
        listQuery = RoleService.getAllRole();
        List<Map<String,Object>> data = listQuery.stream().map(RGetRole::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getAllRoleSuccess");
        response.setMessage(message);
        return response;

    }
}

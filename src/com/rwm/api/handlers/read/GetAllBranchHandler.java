package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetRole;
import com.rwm.api.entities.APIRequest;
import com.rwm.api.entities.response.GetAllBranchResponseData;
import com.rwm.api.entities.response.GetAllRoleResponseData;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.BranchService;
import com.rwm.api.service.RoleService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GetAllBranchHandler extends APIHandler<APIRequest, GetAllBranchResponseData> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetAllBranchHandler() {
        super(APIRequest.class);
    }

    @Override
    protected GetAllBranchResponseData handle(APIRequest request) throws Exception {
        GetAllBranchResponseData response = new GetAllBranchResponseData();

        List<RGetBranch> listQuery = new ArrayList<>();
        listQuery = BranchService.getAllBranch();
        List<Map<String,Object>> data = listQuery.stream().map(RGetBranch::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getAllBranchSuccess");
        response.setMessage(message);
        return response;

    }
}

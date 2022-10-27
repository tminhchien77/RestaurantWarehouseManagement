package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RGetItemByDishIds;
import com.rwm.api.dbresult.RGetUserByUsernamePwd;
import com.rwm.api.entities.request.GetUserByUsernamePwdPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.ItemService;
import com.rwm.api.service.UserService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GetUserHandlerByUsernamePwdHandler extends APIHandler<GetUserByUsernamePwdPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetUserHandlerByUsernamePwdHandler() {
        super(GetUserByUsernamePwdPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(GetUserByUsernamePwdPayLoad request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<RGetUserByUsernamePwd> listQuery = new ArrayList<>();
        listQuery = UserService.getUserByUsernamePwd(request);
        List<Map<String,Object>> data = listQuery.stream().map(RGetUserByUsernamePwd::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getUserByUsernamePwdSuccess");
        response.setMessage(message);
        return response;
    }
}

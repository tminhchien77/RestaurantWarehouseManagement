package com.rwm.api.handlers.read;


import com.rwm.api.dbresult.RGetInvLicenseDetailByInvLicenseId;
import com.rwm.api.dbresult.RGetItemByDishIds;
import com.rwm.api.entities.request.GetByUidPayLoad;
import com.rwm.api.entities.request.GetItemByDishIdsPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.InvLicenseService;
import com.rwm.api.service.ItemService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GetItemByDishIdsHandler extends APIHandler<GetItemByDishIdsPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetItemByDishIdsHandler() {
        super(GetItemByDishIdsPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(GetItemByDishIdsPayLoad request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<RGetItemByDishIds> listQuery = new ArrayList<>();
        listQuery = ItemService.getItemByDishIds(request);
        List<Map<String,Object>> data = listQuery.stream().map(RGetItemByDishIds::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getInvLicenseDetailByInvLicenseIdSuccess");
        response.setMessage(message);
        return response;

    }
}

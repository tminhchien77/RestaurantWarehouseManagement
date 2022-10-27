package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RGetAllItem;
import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.entities.APIRequest;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.BranchService;
import com.rwm.api.service.ItemService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GetAllItemHandler extends APIHandler<APIRequest, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetAllItemHandler() {
        super(APIRequest.class);
    }

    @Override
    protected ResponseDataWithObject handle(APIRequest request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();

        List<RGetAllItem> listQuery = new ArrayList<>();
        listQuery = ItemService.getAllItem();
        List<Map<String,Object>> data = listQuery.stream().map(RGetAllItem::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getAllItemSuccess");
        response.setMessage(message);
        return response;

    }
}
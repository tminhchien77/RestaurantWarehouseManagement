package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RSearchItem;
import com.rwm.api.entities.intermediate.ItemResponse;
import com.rwm.api.entities.request.SearchItemPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.ItemService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class SearchItemHandler extends APIHandler<SearchItemPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public SearchItemHandler() {
        super(SearchItemPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(SearchItemPayLoad request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<ItemResponse> resultList =new ArrayList<>();
        resultList = ItemService.searchItem(request);
//        List<Map<String,Object>> data = listQuery.stream().map(ItemResponse::getValueMap).collect(Collectors.toList());
        response.setData(resultList);
        I18n.load(Global.locale);
        String message = I18n.get("searchItemSuccess");
        response.setMessage(message);
        return response;

    }
}

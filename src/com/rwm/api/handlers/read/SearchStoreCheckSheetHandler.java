package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RSearchStoreCheckSheet;
import com.rwm.api.dbresult.RSearchSupplier;
import com.rwm.api.entities.request.GetByKeywordPayLoad;
import com.rwm.api.entities.request.SearchStoreCheckSheetPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.StoreCheckSheetService;
import com.rwm.api.service.SupplierService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class SearchStoreCheckSheetHandler extends APIHandler<SearchStoreCheckSheetPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public SearchStoreCheckSheetHandler() {
        super(SearchStoreCheckSheetPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(SearchStoreCheckSheetPayLoad request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<RSearchStoreCheckSheet> listQuery =new ArrayList<>();
        listQuery = StoreCheckSheetService.searchStoreCheckSheet(request);
        List<Map<String,Object>> data = listQuery.stream().map(RSearchStoreCheckSheet::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("searchStoreCheckSheetSuccess");
        response.setMessage(message);
        return response;

    }
}

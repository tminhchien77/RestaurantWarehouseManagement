package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RSearchStoreHistoryDetail;
import com.rwm.api.dbresult.RSearchSupplier;
import com.rwm.api.entities.request.GetByKeywordPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.StorageHistoryDetailService;
import com.rwm.api.service.SupplierService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class SearchStoreHistoryDetailHandler extends APIHandler<GetByKeywordPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public SearchStoreHistoryDetailHandler() {
        super(GetByKeywordPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(GetByKeywordPayLoad request) throws Exception {
        System.out.println("alo");
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<RSearchStoreHistoryDetail> listQuery =new ArrayList<>();
        listQuery = StorageHistoryDetailService.searchStoreHistoryDetail(request);
        List<Map<String,Object>> data = listQuery.stream().map(RSearchStoreHistoryDetail::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("searchStoreHistoryDetailSuccess");
        response.setMessage(message);
        return response;

    }
}

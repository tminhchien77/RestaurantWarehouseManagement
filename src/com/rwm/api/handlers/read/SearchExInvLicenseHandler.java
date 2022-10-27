package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RSearchExInvoiceLicense;
import com.rwm.api.dbresult.RSearchInvoiceLicense;
import com.rwm.api.entities.request.SearchInvoiceLicensePayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.InvLicenseService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class SearchExInvLicenseHandler extends APIHandler<SearchInvoiceLicensePayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public SearchExInvLicenseHandler() {
        super(SearchInvoiceLicensePayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(SearchInvoiceLicensePayLoad request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<RSearchExInvoiceLicense> listQuery = new ArrayList<>();
        listQuery = InvLicenseService.searchExInvoiceLicense(request);
        List<Map<String,Object>> data = listQuery.stream().map(RSearchExInvoiceLicense::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("searchExInvoiceLicenseSuccess");
        response.setMessage(message);
        return response;
    }
}

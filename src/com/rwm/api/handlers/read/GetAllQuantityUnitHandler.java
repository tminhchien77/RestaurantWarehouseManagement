package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RGetQuantityUnit;
import com.rwm.api.entities.APIRequest;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.QuantityUnitService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GetAllQuantityUnitHandler extends APIHandler<APIRequest, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetAllQuantityUnitHandler() {
        super(APIRequest.class);
    }

    @Override
    protected ResponseDataWithObject handle(APIRequest request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();

        List<RGetQuantityUnit> listQuery = new ArrayList<>();
        listQuery = QuantityUnitService.getAll(request);
        List<Map<String,Object>> data = listQuery.stream().map(RGetQuantityUnit::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getAllQuantityUnitSuccess");
        response.setMessage(message);
        return response;

    }
}

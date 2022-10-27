package com.rwm.api.service;

import com.rwm.api.dbresult.RGetQuantityUnit;
import com.rwm.api.entities.APIRequest;
import com.rwm.api.repository.QuantityUnitRepository;

import java.util.List;

public class QuantityUnitService {

    private static QuantityUnitService quantityUnitService = null;
    public static QuantityUnitService ins() {
        if (quantityUnitService == null) {
            quantityUnitService = new QuantityUnitService();
        }
        return quantityUnitService;
    }
    public static List<RGetQuantityUnit> getAll(APIRequest request) throws Exception {
        return QuantityUnitRepository.getAll(request);
    }
}

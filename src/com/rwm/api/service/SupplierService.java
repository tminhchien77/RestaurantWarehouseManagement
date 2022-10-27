package com.rwm.api.service;

import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetSupplier;
import com.rwm.api.dbresult.RSearchSupplier;
import com.rwm.api.entities.request.GetByKeywordPayLoad;
import com.rwm.api.entities.request.IntPayLoad;
import com.rwm.api.entities.request.PostSupplierPayLoad;
import com.rwm.api.repository.BranchRepository;
import com.rwm.api.repository.InvLicenseRepository;
import com.rwm.api.repository.SupplierRepository;

import java.util.List;

public class SupplierService {

    private static SupplierService supplierService = null;
    public static SupplierService ins() {
        if (supplierService == null) {
            supplierService = new SupplierService();
        }
        return supplierService;
    }
    public static List<RGetSupplier> getAllSupplier() throws Exception {
        return SupplierRepository.getAllSupplier();
    }

    public static List<RSearchSupplier> searchSupplier(GetByKeywordPayLoad request) throws Exception {
        return SupplierRepository.searchSupplier(request);
    }

    public static void addSupplier(PostSupplierPayLoad request) throws Exception {
        SupplierRepository.fullAddSupplier(request);
    }

    public static RSearchSupplier selectSupplier(IntPayLoad request) throws Exception {
        return SupplierRepository.selectSupplier(request);
    }
}

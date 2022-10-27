package com.rwm.api.service;

import com.rwm.api.dbresult.RGetExInvLicenseDetailByInvLicenseId;
import com.rwm.api.dbresult.RGetInvLicenseDetailByInvLicenseId;
import com.rwm.api.dbresult.RSearchExInvoiceLicense;
import com.rwm.api.dbresult.RSearchInvoiceLicense;
import com.rwm.api.entities.request.*;
import com.rwm.api.repository.InvLicenseRepository;

import java.util.List;

public class InvLicenseService {

    private static InvLicenseService invLicenseService = null;
    public static InvLicenseService ins() {
        if (invLicenseService == null) {
            invLicenseService = new InvLicenseService();
        }
        return invLicenseService;
    }
    public static List<RSearchInvoiceLicense> searchInvoiceLicense(SearchInvoiceLicensePayLoad req) throws Exception {
        return InvLicenseRepository.searchInvoiceLicense(req);
    }

    public static List<RSearchExInvoiceLicense> searchExInvoiceLicense(SearchInvoiceLicensePayLoad req) throws Exception {
        return InvLicenseRepository.searchExInvoiceLicense(req);
    }

    public static String getInvoiceLicenseId() throws Exception {
        return InvLicenseRepository.getInvoiceLicenseId();
    }

    public static void addInvLicense(PostInvLicensePayLoad request) throws Exception {
        InvLicenseRepository.fullAddInvLicense(request);
    }

    public static List<RGetInvLicenseDetailByInvLicenseId> getInvLicenseDetailByInvLicenseId(GetByUidPayLoad request) throws Exception {
        return InvLicenseRepository.getInvLicenseDetailByInvLicenseId(request);
    }

    public static void addInvLicense(PostExInvLicensePayLoad request) throws Exception {
        InvLicenseRepository.fullAddExInvLicense(request);
    }

    public static List<RGetExInvLicenseDetailByInvLicenseId> getExInvLicenseDetailByInvLicenseId(GetByUidPayLoad request) throws Exception {
        return InvLicenseRepository.getExInvLicenseDetailByInvLicenseId(request);
    }
}

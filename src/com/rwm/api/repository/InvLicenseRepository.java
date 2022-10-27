package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.*;
import com.rwm.api.entities.request.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvLicenseRepository {

    private static InvLicenseRepository branchRepository = null;

    public static InvLicenseRepository ins() {
        if (branchRepository == null) {
            branchRepository = new InvLicenseRepository();
        }
        return branchRepository;
    }

    public static List<RSearchInvoiceLicense> searchInvoiceLicense(SearchInvoiceLicensePayLoad req)
            throws Exception {
        System.out.println(req);
        List<RSearchInvoiceLicense> result = new ArrayList<>();

        String callString = "{ ? = call dbo.SP_RW_InvoiceLicense_srh(?, ?, ?, ?, ?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
                proc.registerOutParameter(1, Types.OTHER);
                if(req.getFromDate()!=null)
                    proc.setDate(2, new Date(req.getFromDate().getTime()));
                if(req.getToDate()!=null)
                    proc.setDate(3, new Date(req.getToDate().getTime()));
                proc.setInt(4,req.getSearchType());
                proc.setInt(5,req.getIsExport());
                proc.setString(6,req.getKeyword());
                proc.execute();
                ResultSet resultSet = proc.getResultSet();
                while (resultSet.next()) {
                    RSearchInvoiceLicense obj = new RSearchInvoiceLicense();
                    DBResult.fillData(obj, resultSet);
                    result.add(obj);
                }
                connection.commit();
            }

        return result;
    }

    public static String getInvoiceLicenseId() throws Exception {
        String invoiceLicenseId;
        String callString = "{call dbo.SP_getuniqueidentifier(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.VARCHAR);
            proc.execute();
            invoiceLicenseId = proc.getString(1);
            connection.commit();
        }
        return invoiceLicenseId;
    }

    public static void addInvLicense(Connection connection, PostInvLicensePayLoad request) throws Exception {
        int itemId=-1;
        String callString = "{call dbo.SP_RW_InvoiceLicense_add(?,?,?,?,?,?) }";
        CallableStatement proc = connection.prepareCall(callString);
        proc.setString(1,request.getInvoiceLicenseId());
        proc.setFloat(2, request.getTotalQuantity());
        if(request.getPayment()==null)
            proc.setNull(3, Types.INTEGER);
        else
            proc.setInt(3, request.getPayment());
        proc.setString(4, request.getNote());
        proc.setInt(5, request.getIsExport());
        proc.setInt(6, request.getCreatedUser());
        proc.execute();
    }

    public static void addInvLicenseDetails(Connection connection, PostInvLicensePayLoad req) throws Exception {
        List<PostInvLicenseDetailPayLoad> invLicenseDetails = req.getInvLicenseDetails();
        String callString = "{call dbo.SP_RW_InvoiceLicenseDetail_add(?,?,?,?,?,?,?)}";
        try (CallableStatement proc = connection.prepareCall(callString);) {
            for (PostInvLicenseDetailPayLoad invLicenseDetail: invLicenseDetails) {
                System.out.println("addInvLicenseDetails for");
                proc.setInt(1, invLicenseDetail.getSerial());
                proc.setString(2, req.getInvoiceLicenseId());
                proc.setString(3, invLicenseDetail.getItemSupId());
                if(invLicenseDetail.getProDate()==null)
                    proc.setNull(4, Types.DATE);
                else
                    proc.setDate(4, new Date(invLicenseDetail.getProDate().getTime()));
                proc.setDate(5, new Date(invLicenseDetail.getExpDate().getTime()));
                if(invLicenseDetail.getPrice()==null)
                    proc.setNull(6, Types.INTEGER);
                else
                    proc.setInt(6, invLicenseDetail.getPrice());
                proc.setFloat(7, invLicenseDetail.getQuantity());
                proc.addBatch();
            }
            proc.executeBatch();
        }
    }

    public static void addStoreHistoryDetail(Connection connection, PostInvLicensePayLoad req) throws Exception {
        List<PostInvLicenseDetailPayLoad> invLicenseDetails = req.getInvLicenseDetails();
        String callString = "{call dbo.SP_RW_StoreHistoryDetail_add(?,?,?,?,?)}";
        try (CallableStatement proc = connection.prepareCall(callString);) {
            for (PostInvLicenseDetailPayLoad invLicenseDetail: invLicenseDetails) {
                proc.setString(1, req.getInvoiceLicenseId());
                proc.setString(2, invLicenseDetail.getItemSupId());
                proc.setDate(3, new Date(invLicenseDetail.getExpDate().getTime()));
                proc.setFloat(4, invLicenseDetail.getQuantity());
                proc.setInt(5, req.getIsExport());
                proc.addBatch();
            }
            proc.executeBatch();
        }
    }
    public static void fullAddInvLicense(PostInvLicensePayLoad request) throws Exception {
        try (Connection connection = PgDBConfig.getDbConn().getConnection();) {
            addInvLicense(connection, request);
            addInvLicenseDetails(connection, request);
            addStoreHistoryDetail(connection, request);
            connection.commit();
        }
    }

    public static List<RGetInvLicenseDetailByInvLicenseId> getInvLicenseDetailByInvLicenseId(GetByUidPayLoad req) throws Exception {
        List<RGetInvLicenseDetailByInvLicenseId> result = new ArrayList<>();
        String callString = "{ ? = call dbo.SP_RW_InvoiceLicenseDetail_getbyInvoiceLicenseId(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setString(2,req.getUid());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetInvLicenseDetailByInvLicenseId obj = new RGetInvLicenseDetailByInvLicenseId();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

    public static void fullAddExInvLicense(PostExInvLicensePayLoad request) throws Exception {
        try (Connection connection = PgDBConfig.getDbConn().getConnection();) {
            List<RGetStoreHistoryDetailByItemIdsQuantities> itemSups =new ArrayList<>();
            itemSups= StorageHistoryRepository.getStoreHistoryDetailbyItemIdsQuantities(request.getItemIds(), request.getQuantities());
            PostInvLicensePayLoad tmpPayload=new PostInvLicensePayLoad(request, itemSups);
            addInvLicense(connection, tmpPayload);
            addInvLicenseDetails(connection, tmpPayload);
            addStoreHistoryDetail(connection, tmpPayload);
            connection.commit();
        }
    }

    public static List<RSearchExInvoiceLicense> searchExInvoiceLicense(SearchInvoiceLicensePayLoad req) throws Exception {
        List<RSearchExInvoiceLicense> result = new ArrayList<>();

        String callString = "{ ? = call dbo.SP_RW_InvoiceLicense_srh_exInv(?, ?, ?, ?, ?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            if(req.getFromDate()!=null)
                proc.setDate(2, new Date(req.getFromDate().getTime()));
            if(req.getToDate()!=null)
                proc.setDate(3, new Date(req.getToDate().getTime()));
            proc.setInt(4,req.getSearchType());
            proc.setInt(5,req.getIsExport());
            proc.setString(6,req.getKeyword());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RSearchExInvoiceLicense obj = new RSearchExInvoiceLicense();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

    public static List<RGetExInvLicenseDetailByInvLicenseId> getExInvLicenseDetailByInvLicenseId(GetByUidPayLoad req) throws Exception {
        List<RGetExInvLicenseDetailByInvLicenseId> result = new ArrayList<>();
        String callString = "{ ? = call dbo.SP_RW_InvoiceLicenseDetail_getbyInvoiceLicenseId_Ex(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setString(2,req.getUid());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetExInvLicenseDetailByInvLicenseId obj = new RGetExInvLicenseDetailByInvLicenseId();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }
//    public static List<RGetItemSupsBySupplierId> getItemSupsBySupplierId(IntPayLoad req)
//            throws Exception {
//        List<RGetItemSupsBySupplierId> result = new ArrayList<>();
//
//        String callString = "{ ? = call dbo.SP_MD_Item_Supplier_getbySupplierId(?) }";
//        try (Connection connection = PgDBConfig.getDbConn().getConnection();
//             CallableStatement proc = connection.prepareCall(callString);) {
//            proc.registerOutParameter(1, Types.OTHER);
//            proc.setInt(2,req.getId());
//            proc.execute();
//            ResultSet resultSet = proc.getResultSet();
//            while (resultSet.next()) {
//                RGetItemSupsBySupplierId obj = new RGetItemSupsBySupplierId();
//                DBResult.fillData(obj, resultSet);
//                result.add(obj);
//            }
//            connection.commit();
//        }
//
//        return result;
//    }
}

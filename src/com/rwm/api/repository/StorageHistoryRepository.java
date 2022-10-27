package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.*;
import com.rwm.api.entities.request.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StorageHistoryRepository {

    private static StorageHistoryRepository storageHistoryRepository = null;

    public static StorageHistoryRepository ins() {
        if (storageHistoryRepository == null) {
            storageHistoryRepository = new StorageHistoryRepository();
        }
        return storageHistoryRepository;
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

    public static Integer addImExRequest(Connection connection, PostImExRequestPayLoad request) throws Exception {
        Integer imExRequestId=-1;
        String callString = "{call dbo.SP_RW_ImExRequest_add(?,?) }";
        CallableStatement proc = connection.prepareCall(callString);
        proc.setInt(1, request.getCreatedUserId());
        proc.registerOutParameter(2, Types.INTEGER);
        proc.execute();
        imExRequestId = proc.getInt(2);
        return imExRequestId;
    }

    public static void addImExRequestDetails(Connection connection, Integer imExRequestId, List<PostImExRequestDetailPayLoad> imExRequestDetails) throws Exception {
        String callString = "{call dbo.SP_RW_ImExRequestDetail_add(?,?,?,?)}";
        try (CallableStatement proc = connection.prepareCall(callString);) {
            for (PostImExRequestDetailPayLoad imExRequestDetail: imExRequestDetails) {
                proc.setInt(1, imExRequestDetail.getItemId());
                proc.setFloat(2, imExRequestDetail.getQuantity());
                proc.setInt(3, imExRequestDetail.getQuantityUnitId());
                proc.setInt(4, imExRequestId);
                proc.addBatch();
            }
            proc.executeBatch();
        }
    }
    public static void addStoreHistorys(Connection connection, PostInvLicensePayLoad req) throws Exception {
        List<PostInvLicenseDetailPayLoad> invLicenseDetails = req.getInvLicenseDetails();
        String callString = "{call dbo.SP_RW_StoreHistory_add(?,?,?,?,?)}";
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
    public static void fullAddImExRequest(PostImExRequestPayLoad request) throws Exception {
        try (Connection connection = PgDBConfig.getDbConn().getConnection();) {
            Integer imExRequestId = addImExRequest(connection, request);
            addImExRequestDetails(connection, imExRequestId, request.getImExRequestDetails());
            connection.commit();
        }
    }

    public static List<RGetStoreHistoryByItemId> getStoreHistoryByItemId(IntPayLoad req) throws Exception {
        List<RGetStoreHistoryByItemId> result = new ArrayList<>();
        String callString = "{ ? = call dbo.SP_RW_StoreHistory_getbyItemId(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setInt(2,req.getId());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetStoreHistoryByItemId obj = new RGetStoreHistoryByItemId();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

    public static List<RSearchStoreHistoryDetail> searchStoreHistoryDetail(GetByKeywordPayLoad req) throws Exception {
        List<RSearchStoreHistoryDetail> result = new ArrayList<>();
        String callString = "{ ? = call dbo.SP_RW_StoreHistoryDetail_srh(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setString(2,req.getKeyword());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RSearchStoreHistoryDetail obj = new RSearchStoreHistoryDetail();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

    public static List<RGetStoreHistoryDetailByCheckSheetId> getStoreHistoryDetailByCheckSheetId(IntPayLoad req) throws Exception {
        List<RGetStoreHistoryDetailByCheckSheetId> result = new ArrayList<>();
        String callString = "{ ? = call dbo.SP_RW_StoreHistoryDetail_getbyCheckSheetId(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setInt(2,req.getId());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetStoreHistoryDetailByCheckSheetId obj = new RGetStoreHistoryDetailByCheckSheetId();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

    public static List<RGetStoreHistoryDetailByItemIdsQuantities> getStoreHistoryDetailbyItemIdsQuantities(String itemIds, String quantities) throws Exception {
        System.out.println("itemIds");
        System.out.println(itemIds);
        System.out.println("quantities");
        System.out.println(quantities);
        List<RGetStoreHistoryDetailByItemIdsQuantities> result = new ArrayList<>();
        String callString = "{ ? = call dbo.SP_RW_StoreHistoryDetail_getbyItemIds_Quantities(?,?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setString(2, itemIds);
            proc.setString(3, quantities);
            proc.executeQuery();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetStoreHistoryDetailByItemIdsQuantities obj = new RGetStoreHistoryDetailByItemIdsQuantities();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }
//
}

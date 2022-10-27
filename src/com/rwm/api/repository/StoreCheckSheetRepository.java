package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.*;
import com.rwm.api.entities.request.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreCheckSheetRepository {

    private static StoreCheckSheetRepository storeCheckSheetRepository = null;

    public static StoreCheckSheetRepository ins() {
        if (storeCheckSheetRepository == null) {
            storeCheckSheetRepository = new StoreCheckSheetRepository();
        }
        return storeCheckSheetRepository;
    }

    public static void fullAddStoreCheckSheet(PostStoreCheckSheetPayLoad request) throws Exception {
        try (Connection connection = PgDBConfig.getDbConn().getConnection();) {
            Integer checkSheetId = addStoreCheckSheet(connection, request);
            addItemSupsCheckingStore(connection, checkSheetId, request.getItemSupsCheckingStore());
            connection.commit();
        }
    }

    private static void addItemSupsCheckingStore(Connection connection, Integer checkSheetId, List<PostItemSupCheckingStore> itemSupsCheckingStore) throws SQLException {
        String callString = "{call dbo.SP_RW_StoreHistoryDetail_addCheckStore(?,?,?,?)}";
        try (CallableStatement proc = connection.prepareCall(callString);) {
            for (PostItemSupCheckingStore itemSupCheckingStore: itemSupsCheckingStore) {
                proc.setInt(1, checkSheetId);
                proc.setString(2, itemSupCheckingStore.getItemSupId());
                proc.setDate(3, new Date(itemSupCheckingStore.getExpDate().getTime()));
                proc.setFloat(4, itemSupCheckingStore.getRemainQuantity());
                proc.addBatch();
            }
            proc.executeBatch();
        }
    }

    private static Integer addStoreCheckSheet(Connection connection, PostStoreCheckSheetPayLoad request) throws SQLException {
        Integer checkSheetId=-1;
        String callString = "{call dbo.SP_RW_StoreCheckSheet_add(?,?,?) }";
        CallableStatement proc = connection.prepareCall(callString);
        proc.setInt(1,request.getCreatedUser());
        proc.setString(2, request.getNote());
        proc.registerOutParameter(3, Types.INTEGER);
        proc.execute();
        checkSheetId = proc.getInt(3);
        return checkSheetId;
    }

    public static List<RSearchStoreCheckSheet> searchStoreCheckSheet(SearchStoreCheckSheetPayLoad req) throws Exception {
        List<RSearchStoreCheckSheet> result = new ArrayList<>();

        String callString = "{ ? = call dbo.SP_RW_StoreCheckSheet_srh(?,?,?,?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setInt(2,req.getSearchType());
            proc.setString(3,req.getKeyword());
            if(req.getFromDate()!=null)
                proc.setDate(4, new Date(req.getFromDate().getTime()));
            if(req.getToDate()!=null)
                proc.setDate(5, new Date(req.getToDate().getTime()));
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RSearchStoreCheckSheet obj = new RSearchStoreCheckSheet();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }
}

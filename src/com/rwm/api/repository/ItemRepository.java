package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.*;
import com.rwm.api.entities.request.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private static ItemRepository branchRepository = null;

    public static ItemRepository ins() {
        if (branchRepository == null) {
            branchRepository = new ItemRepository();
        }
        return branchRepository;
    }

    public static List<RSearchItem> searchItem(SearchItemPayLoad req)
            throws Exception {
        List<RSearchItem> result = new ArrayList<>();

        String callString = "{ ? = call dbo.SP_MD_Item_srh(?, ?, ?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
                proc.registerOutParameter(1, Types.OTHER);
                proc.setInt(2, req.getBranchid());
                proc.setInt(3, req.getSupplierId());
                proc.setString(4,req.getKeyword());
                proc.execute();
                ResultSet resultSet = proc.getResultSet();
                while (resultSet.next()) {
                    RSearchItem obj = new RSearchItem();
                    DBResult.fillData(obj, resultSet);
                    result.add(obj);
                }
                connection.commit();
            }

        return result;
    }
    public static void addItem(PostItemPayLoad request, String fileName) throws Exception {
        String callString = "{call dbo.SP_MD_Item_add(?,?,?,?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.setString(1,request.getItemName());
            proc.setInt(2, request.getBranchId());
            proc.setInt(3, request.getQuantityUnitId());
            proc.setString(4, fileName);
            proc.execute();
            connection.commit();
        }
    }
//    public static void addItemSups(Connection connection, Integer itemId, List<PostItemSupPayLoad> itemSups) throws Exception {
//        String callString = "{call dbo.SP_MD_Item_Supplier_add(?,?,?)}";
//        try (CallableStatement proc = connection.prepareCall(callString);) {
//            for (PostItemSupPayLoad itemSup: itemSups) {
//                proc.setInt(1, itemId);
//                proc.setInt(2, itemSup.getSupplierId());
//                proc.setInt(3, itemSup.getQuantityUnitId());
//                proc.addBatch();
//            }
//            proc.executeBatch();
//        }
//    }
//    public static void addItemSups(Integer itemId, List<PostItemSupPayLoad> itemSups) throws Exception {
//        String callString = "{call dbo.SP_MD_Item_Supplier_add(?,?,?)}";
//        try (Connection connection = PgDBConfig.getDbConn().getConnection();
//             CallableStatement proc = connection.prepareCall(callString);) {
//            for (PostItemSupPayLoad itemSup: itemSups) {
//                proc.setInt(1, itemId);
//                proc.setInt(2, itemSup.getSupplierId());
//                proc.setInt(3, itemSup.getQuantityUnitId());
//                proc.addBatch();
//            }
//            proc.executeBatch();
//            connection.commit();
//        }
//    }
//    public static void fulAddItem(PostItemPayLoad request, String fileName) throws Exception {
//        try (Connection connection = PgDBConfig.getDbConn().getConnection();) {
//            Integer itemId = addItem(connection, request, fileName);
//            addItemSups(connection, itemId, request.getItemSups());
//            connection.commit();
//        }
//    }

    public static List<RGetItemSup> getItemSupsByItemId(IntPayLoad reqest)
            throws Exception {
        List<RGetItemSup> result = new ArrayList<>();

        String callString = "{ ? = call dbo.SP_MD_Item_Supplier_getbyItemId(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setInt(2, reqest.getId());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetItemSup obj = new RGetItemSup();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }
    public static String updItem(PutItemPayLoad request, String fileName) throws Exception {
        String oldFilePath="";
        String callString = "{call dbo.SP_MD_Item_upd(?,?,?,?,?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {

            proc.setInt(1, request.getItemId());
            proc.setString(2,request.getItemName());
            proc.setInt(3, request.getBranchId());
            proc.setString(4, fileName);
            proc.registerOutParameter(5, Types.VARCHAR);
            proc.execute();
            oldFilePath = proc.getString(5);
            connection.commit();
        }
        return oldFilePath;

    }

    public static void delItemSups(DeleteItemSupsPayLoad request) throws Exception {
        String callString = "{call dbo.SP_MD_Item_Supplier_del(?)}";
        try (
                Connection connection = PgDBConfig.getDbConn().getConnection();
                CallableStatement proc = connection.prepareCall(callString);
        ) {
            for (String itemSupId: request.getItemSupIds()) {
                proc.setString(1, itemSupId);
                proc.addBatch();
            }
            proc.executeBatch();
            connection.commit();
        }
    }

    public static List<RGetItemByDishIds> getItemByDishIds(GetItemByDishIdsPayLoad req) throws Exception {


        List<RGetItemByDishIds> result = new ArrayList<>();
        String callString = "{ ? = call dbo.SP_MD_Item_getbyDishIds(?,?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setString(2, req.getDishIds());
            proc.setString(3, req.getQuantities());
            proc.executeQuery();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetItemByDishIds obj = new RGetItemByDishIds();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

    public static List<RGetAllItem> getAllItem() throws Exception {
        List<RGetAllItem> result = new ArrayList<>();

        String callString = "{ ? = call dbo.SP_MD_Item_getall() }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetAllItem obj = new RGetAllItem();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

    public static void delItem(IntPayLoad req) throws Exception {
        String callString = "{call dbo.SP_MD_Item_del(?)}";
        try (
                Connection connection = PgDBConfig.getDbConn().getConnection();
                CallableStatement proc = connection.prepareCall(callString);
        ) {
            proc.setInt(1, req.getId());
            proc.execute();
            connection.commit();
        }
    }
}

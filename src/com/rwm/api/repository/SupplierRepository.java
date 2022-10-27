package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.DBResult;
import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetSupplier;
import com.rwm.api.dbresult.RSearchSupplier;
import com.rwm.api.entities.request.GetByKeywordPayLoad;
import com.rwm.api.entities.request.IntPayLoad;
import com.rwm.api.entities.request.PostItemSupPayLoad;
import com.rwm.api.entities.request.PostSupplierPayLoad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepository {

    private static SupplierRepository supplierRepository = null;

    public static SupplierRepository ins() {
        if (supplierRepository == null) {
            supplierRepository = new SupplierRepository();
        }
        return supplierRepository;
    }

    public static List<RGetSupplier> getAllSupplier()
            throws Exception {
        List<RGetSupplier> result = new ArrayList<>();

            String callString = "{ ? = call dbo.SP_MD_Supplier_getall() }";
            try (Connection connection = PgDBConfig.getDbConn().getConnection();
                 CallableStatement proc = connection.prepareCall(callString);) {
                proc.registerOutParameter(1, Types.OTHER);
                proc.execute();
                ResultSet resultSet = proc.getResultSet();
                while (resultSet.next()) {
                    RGetSupplier obj = new RGetSupplier();
                    DBResult.fillData(obj, resultSet);
                    result.add(obj);
                }
                connection.commit();
            }

        return result;
    }

    public static List<RSearchSupplier> searchSupplier(GetByKeywordPayLoad request) throws Exception {
        List<RSearchSupplier> result = new ArrayList<>();

        String callString = "{ ? = call dbo.SP_MD_Supplier_srh(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setString(2,request.getKeyword());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RSearchSupplier obj = new RSearchSupplier();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

    public static void fullAddSupplier(PostSupplierPayLoad request) throws Exception {
        try (Connection connection = PgDBConfig.getDbConn().getConnection();) {
            Integer supplierId = addSupplier(connection, request);
            addItemSups(connection, supplierId, request.getItemSups());
            connection.commit();
        }
    }

    private static void addItemSups(Connection connection, Integer supplierId, List<PostItemSupPayLoad> itemSups) throws SQLException {
        String callString = "{call dbo.SP_MD_Item_Supplier_add(?,?,?)}";
        try (CallableStatement proc = connection.prepareCall(callString);) {
            for (PostItemSupPayLoad itemSup: itemSups) {
                proc.setInt(1, itemSup.getItemId());
                proc.setInt(2, supplierId);
                proc.setInt(3, itemSup.getQuantityUnitId());
                proc.addBatch();
            }
            proc.executeBatch();
        }
    }

    private static Integer addSupplier(Connection connection, PostSupplierPayLoad request) throws SQLException {
        Integer supplierId=-1;
        String callString = "{call dbo.SP_MD_Supplier_add(?,?,?,?,?,?) }";
        CallableStatement proc = connection.prepareCall(callString);
        proc.setString(1,request.getSupplierName());
        proc.setString(2, request.getAddress());
        proc.setString(3, request.getPhone());
        proc.setString(4, request.getEmail());
        proc.setString(5, request.getFax());
        proc.registerOutParameter(6, Types.INTEGER);
        proc.execute();
        supplierId = proc.getInt(6);
        return supplierId;
    }

    public static RSearchSupplier selectSupplier(IntPayLoad request) throws Exception {
        RSearchSupplier result = new RSearchSupplier();

        String callString = "{ ? = call dbo.SP_MD_Supplier_sel(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setInt(2,request.getId());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                DBResult.fillData(result, resultSet);
            }
            connection.commit();
        }

        return result;
    }
}

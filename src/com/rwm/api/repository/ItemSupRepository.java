package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.DBResult;
import com.rwm.api.dbresult.RGetItemSupsBySupplierId;
import com.rwm.api.entities.request.IntPayLoad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ItemSupRepository {

    private static ItemSupRepository itemSupRepository = null;

    public static ItemSupRepository ins() {
        if (itemSupRepository == null) {
            itemSupRepository = new ItemSupRepository();
        }
        return itemSupRepository;
    }

    public static List<RGetItemSupsBySupplierId> getItemSupsBySupplierId(IntPayLoad req)
            throws Exception {
        List<RGetItemSupsBySupplierId> result = new ArrayList<>();

        String callString = "{ ? = call dbo.SP_MD_Item_Supplier_getbySupplierId(?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setInt(2,req.getId());
            proc.execute();
            ResultSet resultSet = proc.getResultSet();
            while (resultSet.next()) {
                RGetItemSupsBySupplierId obj = new RGetItemSupsBySupplierId();
                DBResult.fillData(obj, resultSet);
                result.add(obj);
            }
            connection.commit();
        }

        return result;
    }

//    public static void addItem(PostAccountPayLoad request) throws Exception {
//
//        String callString = "{ ? = call dbo.spDangKy(?,?,?,?,?,?) }";
//        try (Connection connection = PgDBConfig.getDbConn().getConnection();
//             CallableStatement proc = connection.prepareCall(callString);) {
//            proc.registerOutParameter(1, Types.OTHER);
//            proc.setString(2,request.getEmail());
//            proc.setString(3, request.getPassword());
//            proc.setString(4, request.getPhone());
//            proc.setString(5,request.getAddress());
//            proc.setString(6, request.getName());
//            proc.setInt(7, request.getIdRole());
//            proc.execute();
//
//            connection.commit();
//        }
//    }

}

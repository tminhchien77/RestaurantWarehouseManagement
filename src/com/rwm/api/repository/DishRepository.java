package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.DBResult;
import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetDish;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DishRepository {

    private static DishRepository dishRepository = null;

    public static DishRepository ins() {
        if (dishRepository == null) {
            dishRepository = new DishRepository();
        }
        return dishRepository;
    }

    public static List<RGetDish> getAllDish()
            throws Exception {
        List<RGetDish> result = new ArrayList<>();

            String callString = "{ ? = call dbo.SP_MD_Dish_getall() }";
            try (Connection connection = PgDBConfig.getDbConn().getConnection();
                 CallableStatement proc = connection.prepareCall(callString);) {
                proc.registerOutParameter(1, Types.OTHER);
                proc.execute();
                ResultSet resultSet = proc.getResultSet();
                while (resultSet.next()) {
                    RGetDish obj = new RGetDish();
                    DBResult.fillData(obj, resultSet);
                    result.add(obj);
                }
                connection.commit();
            }

        return result;
    }

}

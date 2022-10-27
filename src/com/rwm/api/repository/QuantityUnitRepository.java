package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.DBResult;
import com.rwm.api.dbresult.RGetQuantityUnit;
import com.rwm.api.entities.APIRequest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class QuantityUnitRepository {

    private static QuantityUnitRepository quantityUnitRepository = null;

    public static QuantityUnitRepository ins() {
        if (quantityUnitRepository == null) {
            quantityUnitRepository = new QuantityUnitRepository();
        }
        return quantityUnitRepository;
    }

    public static List<RGetQuantityUnit> getAll(APIRequest request)
            throws Exception {
        List<RGetQuantityUnit> result = new ArrayList<>();

            String callString = "{ ? = call dbo.SP_MD_QuantityUnit_getall() }";
            try (Connection connection = PgDBConfig.getDbConn().getConnection();
                 CallableStatement proc = connection.prepareCall(callString);) {
                proc.registerOutParameter(1, Types.OTHER);
                proc.execute();
                ResultSet resultSet = proc.getResultSet();
                while (resultSet.next()) {
                    RGetQuantityUnit obj = new RGetQuantityUnit();
                    DBResult.fillData(obj, resultSet);
                    result.add(obj);
                }
                connection.commit();
            }

        return result;
    }

}

package com.hdv.api.repository;

import com.hdv.api.configs.PgDBConfig;
import com.hdv.api.dbresult.DBResult;
import com.hdv.api.dbresult.RGetRole;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {

    private static RoleRepository roleRepository = null;

    public static RoleRepository ins() {
        if (roleRepository == null) {
            roleRepository = new RoleRepository();
        }
        return roleRepository;
    }

    public static List<RGetRole> getAllRole()
            throws Exception {
        List<RGetRole> result = new ArrayList<>();

            String callString = "{ ? = call dbo.SP_GetAllRole() }";
            try (Connection connection = PgDBConfig.getDbConn().getConnection();
                 CallableStatement proc = connection.prepareCall(callString);) {
                proc.registerOutParameter(1, Types.OTHER);
                proc.execute();
                ResultSet resultSet = proc.getResultSet();
                while (resultSet.next()) {
                    RGetRole obj = new RGetRole();
                    DBResult.fillData(obj, resultSet);
                    result.add(obj);
                }
                connection.commit();
            }

        return result;
    }

}

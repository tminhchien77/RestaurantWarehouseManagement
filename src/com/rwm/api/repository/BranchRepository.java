package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.DBResult;
import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetRole;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BranchRepository {

    private static BranchRepository branchRepository = null;

    public static BranchRepository ins() {
        if (branchRepository == null) {
            branchRepository = new BranchRepository();
        }
        return branchRepository;
    }

    public static List<RGetBranch> getAllBranch()
            throws Exception {
        List<RGetBranch> result = new ArrayList<>();

            String callString = "{ ? = call dbo.SP_MD_Branch_getall() }";
            try (Connection connection = PgDBConfig.getDbConn().getConnection();
                 CallableStatement proc = connection.prepareCall(callString);) {
                proc.registerOutParameter(1, Types.OTHER);
                proc.execute();
                ResultSet resultSet = proc.getResultSet();
                while (resultSet.next()) {
                    RGetBranch obj = new RGetBranch();
                    DBResult.fillData(obj, resultSet);
                    result.add(obj);
                }
                connection.commit();
            }

        return result;
    }

}

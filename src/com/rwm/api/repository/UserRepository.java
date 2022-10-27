package com.rwm.api.repository;

import com.rwm.api.configs.PgDBConfig;
import com.rwm.api.dbresult.DBResult;
import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.dbresult.RGetUserByUsernamePwd;
import com.rwm.api.dbresult.RSearchItem;
import com.rwm.api.entities.request.GetUserByUsernamePwdPayLoad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository userRepository = null;

    public static UserRepository ins() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public static List<RGetUserByUsernamePwd> getUserByUsernamePwd(GetUserByUsernamePwdPayLoad req)
            throws Exception {
        List<RGetUserByUsernamePwd> result = new ArrayList<>();

            String callString = "{ ? = call dbo.SP_SYS_User_getbyUsername_Pwd(?,?) }";
            try (Connection connection = PgDBConfig.getDbConn().getConnection();
                 CallableStatement proc = connection.prepareCall(callString);) {
                proc.registerOutParameter(1, Types.OTHER);
                proc.setString(2, req.getUsername());
                proc.setString(3, req.getPwd());
                proc.execute();
                ResultSet resultSet = proc.getResultSet();
                while (resultSet.next()) {
                    RGetUserByUsernamePwd obj = new RGetUserByUsernamePwd();
                    DBResult.fillData(obj, resultSet);
                    result.add(obj);
                }
                connection.commit();
            }

        return result;
    }

}

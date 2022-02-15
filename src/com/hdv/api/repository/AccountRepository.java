package com.hdv.api.repository;

import com.hdv.api.configs.PgDBConfig;
import com.hdv.api.entities.request.PostAccountPayLoad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class AccountRepository {

    private static AccountRepository accountRepository = null;

    public static AccountRepository ins() {
        if (accountRepository == null) {
            accountRepository = new AccountRepository();
        }
        return accountRepository;
    }

    public static void createAccount(PostAccountPayLoad request) throws Exception {

        String callString = "{ ? = call dbo.spDangKy(?,?,?,?,?,?) }";
        try (Connection connection = PgDBConfig.getDbConn().getConnection();
             CallableStatement proc = connection.prepareCall(callString);) {
            proc.registerOutParameter(1, Types.OTHER);
            proc.setString(2,request.getUser().getEmail());
            proc.setString(3, request.getUser().getPassword());
            proc.setString(4, request.getUser().getPhone());
            proc.setString(5,request.getUser().getAddress());
            proc.setString(6, request.getUser().getName());
            proc.setInt(7, request.getUser().getIdRole());
            proc.execute();

            connection.commit();
        }
    }
}

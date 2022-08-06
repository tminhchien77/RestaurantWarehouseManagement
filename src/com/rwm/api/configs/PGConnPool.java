package com.rwm.api.configs;

public class PGConnPool extends DBConnPool {

  public PGConnPool(String connStr, String user, String pass, int maxConn) throws Exception {
    super(com.microsoft.sqlserver.jdbc.SQLServerDriver.class, connStr, user, pass, maxConn);
  }

}

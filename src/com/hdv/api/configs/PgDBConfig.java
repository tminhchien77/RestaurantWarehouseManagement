package com.hdv.api.configs;

import com.hdv.api.ApplicationService;

public class PgDBConfig {

	public static final int CONN_CONFIG_POS = 0;

	public static DBConnPool dbConn;

	public static DBConnPool getDbConn() throws Exception {
		if (dbConn == null) {
			return doPGConnPool();
		}
		return dbConn;
	}

	private static synchronized DBConnPool doPGConnPool() throws Exception{
		if (dbConn == null) {
			DBConnConfig dbConnConfig = ApplicationService.getDBConnConfig(CONN_CONFIG_POS);
			dbConn = new PGConnPool(dbConnConfig.getConnStr(),
									dbConnConfig.getUser(),
									dbConnConfig.getPass(),
									dbConnConfig.getMaxConn());
		}
		return dbConn;
	}

}

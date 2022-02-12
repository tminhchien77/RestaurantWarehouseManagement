package com.hdv.api.configs;

public class DBConnConfig {

	private String connStr;
	
	private String user;
	
	private String pass;
	
	private int maxConn;

	public DBConnConfig(String connStr, String user, String pass, int maxConn) {
		super();
		this.connStr = connStr;
		this.user = user;
		this.pass = pass;
		this.maxConn = maxConn;
	}

	public String getConnStr() {
		return connStr;
	}

	public void setConnStr(String connStr) {
		this.connStr = connStr;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getMaxConn() {
		return maxConn;
	}

	public void setMaxConn(int maxConn) {
		this.maxConn = maxConn;
	}


	
}

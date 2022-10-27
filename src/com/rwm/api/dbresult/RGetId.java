package com.rwm.api.dbresult;

public class RGetId extends DBResult{

	public RGetId() {
		addField("id", DataType.INTEGER, 0);
	}

	public Integer getId() {
		return (Integer) this.getValue("id");
	}

	public String getRoleName() {
		return (String) this.getValue("roleName");
	}
}

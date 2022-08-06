package com.rwm.api.dbresult;

public class RGetBranch extends DBResult{

	public RGetBranch() {
		addField("BranchId", DataType.INTEGER, 0);
		addField("BranchName", DataType.STRING, "");
	}

	public Integer getId() {
		return (Integer) this.getValue("BranchId");
	}

	public String getBranchName() {
		return (String) this.getValue("BranchName");
	}
}

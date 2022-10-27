package com.rwm.api.dbresult;

public class RSearchItem extends DBResult{

	public RSearchItem() {
		addField("ItemId", DataType.INTEGER, 0);
		addField("ItemName", DataType.STRING, "");
		addField("QuantityUnitId", DataType.INTEGER, 0);
		addField("ItemImg", DataType.STRING, "");
		addField("BranchId", DataType.INTEGER, 0);
		addField("BranchName", DataType.STRING, "");
		addField("CountUsed", DataType.INTEGER, 0);
	}

	public Integer getItemId() {
		return (Integer) this.getValue("ItemId");
	}

	public String getItemName() {
		return (String) this.getValue("ItemName");
	}
	public Integer getQuantityUnitId() {
		return (Integer) this.getValue("QuantityUnitId");
	}
	public String getItemImg() {
		return (String) this.getValue("ItemImg");
	}
	public Integer getBranchId() {
		return (Integer) this.getValue("BranchId");
	}
	public String getBranchName() {
		return (String) this.getValue("BranchName");
	}
	public Integer getCountUsed() {
		return (Integer) this.getValue("CountUsed");
	}
}

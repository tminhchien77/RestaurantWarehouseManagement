package com.rwm.api.dbresult;

public class RGetItemSupsBySupplierId extends DBResult{

	public RGetItemSupsBySupplierId() {
		addField("ItemSupId", DataType.STRING, "");
		addField("ItemId", DataType.INTEGER, 0);
		addField("ItemName", DataType.STRING, "");
		addField("QuantityUnitId", DataType.INTEGER, 0);
		addField("QuantityUnitName", DataType.STRING, "");
	}

	public String getItemSupId() {
		return (String) this.getValue("ItemSupId");
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
	public String getQuantityUnitName() {
		return (String) this.getValue("QuantityUnitName");
	}


}

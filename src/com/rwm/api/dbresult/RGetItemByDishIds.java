package com.rwm.api.dbresult;

public class RGetItemByDishIds extends DBResult{

	public RGetItemByDishIds() {
		addField("ItemId", DataType.INTEGER, 0);
		addField("ItemName", DataType.STRING, "");
		addField("Quantity", DataType.FLOAT, "");
		addField("QuantityUnitId", DataType.INTEGER, 0);
		addField("QuantityUnitName", DataType.STRING, "");
		addField("Status", DataType.INTEGER, 0);
	}

	public Integer getItemId() {
		return (Integer) this.getValue("ItemId");
	}
	public String getItemName() {
		return (String) this.getValue("ItemName");
	}
	public Float getQuantity() {
		return (Float) this.getValue("Quantity");
	}
	public Integer getQuantityUnitId() {
		return (Integer) this.getValue("QuantityUnitId");
	}
	public String getQuantityUnitName() {
		return (String) this.getValue("QuantityUnitName");
	}
	public Integer getStatus() {
		return (Integer) this.getValue("Status");
	}
}

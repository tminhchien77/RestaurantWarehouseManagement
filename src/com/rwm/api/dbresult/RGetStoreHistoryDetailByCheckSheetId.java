package com.rwm.api.dbresult;

import java.util.Date;

public class RGetStoreHistoryDetailByCheckSheetId extends DBResult{

	public RGetStoreHistoryDetailByCheckSheetId() {
		addField("ItemSupId", DataType.STRING, "");
		addField("ItemName", DataType.STRING, "");
		addField("SupplierName", DataType.STRING, "");
		addField("ExpDate", DataType.DATE, 0);
		addField("BeforeRemainQuantity", DataType.FLOAT, "");
		addField("RemainQuantity", DataType.FLOAT, "");
		addField("QuantityUnitName", DataType.STRING, 0);
	}

	public String getItemSupId() {
		return (String) this.getValue("ItemSupId");
	}
	public String getItemName() {
		return (String) this.getValue("ItemName");
	}
	public String getSupplierName() {
		return (String) this.getValue("SupplierName");
	}
	public Date getExpDate() {
		return (Date) this.getValue("ExpDate");
	}
	public Float getBeforeRemainQuantity() {
		return (Float) this.getValue("BeforeRemainQuantity");
	}
	public Float getRemainQuantity() {
		return (Float) this.getValue("RemainQuantity");
	}
	public String getQuantityUnitName() {
		return (String) this.getValue("QuantityUnitName");
	}
}
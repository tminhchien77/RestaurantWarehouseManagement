package com.rwm.api.dbresult;

import java.util.Date;

public class RGetStoreHistoryByItemId extends DBResult{

	public RGetStoreHistoryByItemId() {
		addField("ItemSupId", DataType.STRING, "");
		addField("SupplierName", DataType.STRING, "");
		addField("ExpDate", DataType.DATE, "");
		addField("RemainQuantity", DataType.FLOAT, 0);
	}

	public String getItemSupId() {
		return (String) this.getValue("ItemSupId");
	}
	public String getSupplierName() {
		return (String) this.getValue("SupplierName");
	}
	public Date getExpDate() {
		return (Date) this.getValue("ExpDate");
	}
	public Float getRemainQuantity() {
		return (Float) this.getValue("RemainQuantity");
	}


}

package com.rwm.api.dbresult;

import java.util.Date;

public class RGetStoreHistoryDetailByItemIdsQuantities extends DBResult{
	private String itemSupId;
	private Date expDate;
	private Float quantity;

	public RGetStoreHistoryDetailByItemIdsQuantities() {
		addField("ItemSupId", DataType.STRING, 0);
		addField("ExpDate", DataType.DATE, "");
		addField("Quantity", DataType.FLOAT, 0);
	}

	public String getItemSupId() {
		return (String) this.getValue("ItemSupId");
	}
	public Date getExpDate() {
		return (Date) this.getValue("ExpDate");
	}
	public Float getQuantity() {
		return (Float) this.getValue("Quantity");
	}

}

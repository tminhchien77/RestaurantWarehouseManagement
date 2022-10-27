package com.rwm.api.dbresult;

import java.util.Date;

public class RGetInvLicenseDetailByInvLicenseId extends DBResult{

	public RGetInvLicenseDetailByInvLicenseId() {
		addField("Serial", DataType.INTEGER, 0);
		addField("ItemSupId", DataType.STRING, "");
		addField("ItemName", DataType.STRING, "");
		addField("ProDate", DataType.DATE, "");
		addField("ExpDate", DataType.DATE, "");
		addField("Price", DataType.INTEGER, 0);
		addField("Quantity", DataType.FLOAT, 0);
		addField("QuantityUnitName", DataType.STRING, "");
	}
	public Integer getSerial() {
		return (Integer) this.getValue("Serial");
	}
	public String getItemSupId() {
		return (String) this.getValue("ItemSupId");
	}
	public String getItemName() {
		return (String) this.getValue("ItemName");
	}
	public Date getProDate() {
		return (Date) this.getValue("ProDate");
	}
	public Date getExpDate() {
		return (Date) this.getValue("ExpDate");
	}
	public Integer getPrice() {
		return (Integer) this.getValue("Price");
	}
	public Float getQuantity() {
		return (Float) this.getValue("Quantity");
	}
	public String getQuantityUnitName() {
		return (String) this.getValue("QuantityUnitName");
	}


}

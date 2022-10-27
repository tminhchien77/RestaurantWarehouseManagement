package com.rwm.api.dbresult;

public class RGetDish extends DBResult{

	public RGetDish() {
		addField("DishId", DataType.INTEGER, 0);
		addField("DishName", DataType.STRING, "");
	}

	public Integer getDishId() {
		return (Integer) this.getValue("DishId");
	}
	public String getDishName() {
		return (String) this.getValue("DishName");
	}
}

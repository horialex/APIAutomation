package com.entities;

public class Item {

	private String title;
	private int category_id;
	private Object[] custom_fields;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public Object[] getCustom_fields() {
		return custom_fields;
	}

	public void setCustom_fields(Object[] custom_fields) {
		this.custom_fields = custom_fields;
	}

}

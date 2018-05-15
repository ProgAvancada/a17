package br.pucpr.annotations;

import java.lang.reflect.Field;

public class TableColumn implements Comparable<TableColumn> {
	private int order = Integer.MAX_VALUE;
	private String header = null;
	private Field field;
	private String format;
	
	public TableColumn(Field field) {
		this.field = field;
	}
	
	public String format(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Object value = field.get(obj);
		if (value == null) return "";
		if (format.isEmpty()) return value.toString();
		return String.format(format, value);				
	}
	
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int compareTo(TableColumn other) {
		if (order < other.order) return -1;
		if (order > other.order) return 1;		
		return 0;
	}
	
	public String getHeader() {
		return header == null ? "" :
				(header.isEmpty() ? field.getName() : header);
	}

	public void setHeader(String name) {
		this.header = name;		
	}

	public void setFormat(String format) {
		this.format = format;
	}
}

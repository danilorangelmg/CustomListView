package com.example.dbprovider.listener;

public interface QueryListener {

	public String initQuery();
	
	public String onQueryChange(String[] params);
	
	
}

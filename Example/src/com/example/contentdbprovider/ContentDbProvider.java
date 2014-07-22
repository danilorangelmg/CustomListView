package com.example.contentdbprovider;

import android.app.Application;

public class ContentDbProvider extends Application {

	private static ContentDbProvider instance;
	
	public ContentDbProvider() {
		instance = this;
	}

	public static ContentDbProvider getApplication() {
		return instance;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		createAndConfigureDatabase();
	}
	
	private void createAndConfigureDatabase() {
		//here you should create a database and tables.
	}
	
}

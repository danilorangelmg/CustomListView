package com.example.dbprovider.content;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class ApplicationProvider extends ContentProvider {
	private static final String AUTHORITY = "br.com.softbox.ivendas.dbprovider.content.ApplicationProvider";
	//		private static final Uri CONTENT_URI =  Uri.parse("content://" + AUTHORITY + "/Produto");
	//		private static final Uri CONTENT_ID_URI_BASE = Uri.parse("content://" + AUTHORITY + "/Produto/");
	private static Uri content_id_uri_base = null;
	private static Uri content_id_uri = null;

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
//		try {

			Uri noteUri = ContentUris.withAppendedId(content_id_uri_base, 0);
			getContext().getContentResolver().notifyChange(noteUri, null);
			return noteUri;
//		} catch (DAOException e) {
//			e.printStackTrace();
	//	}
//		return uri;
	}

	@Override
	public boolean onCreate() {
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,	String[] selectionArgs, String sortOrder) {
		Cursor cursor = null;
//		cursor = your dao selected.

		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		Uri noteUri = ContentUris.withAppendedId(content_id_uri_base, (int)Math.random()*10000);
		getContext().getContentResolver().notifyChange(noteUri, null);
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return 0;
	}


	public static void setContentURI(String className) {
		String strURI = "content://" + AUTHORITY + "/" +className+"/";
		content_id_uri_base = Uri.parse(strURI);
		content_id_uri = Uri.parse(strURI.substring(0, strURI.length()-1));
		
		
	}
	
	public static Uri getContentURI() {
		return content_id_uri;
	}


}

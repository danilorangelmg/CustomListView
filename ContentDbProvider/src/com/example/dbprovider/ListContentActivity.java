package com.example.dbprovider;

import java.util.HashMap;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.dbprovider.adapter.ContentCursorAdapter;
import com.example.dbprovider.content.ApplicationProvider;
import com.example.dbprovider.listener.QueryListener;



public abstract class ListContentActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {

	public final String QUERY = "query";
	private static final int THE_LOADER = 0x01;
	private boolean isPositionSearch = false;
	private int actualPosition = - 1;
	private int lastPosition;
	private HashMap<Integer, View> views = new HashMap<Integer, View>();
	private View selectedView;
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			init();
		} catch (NullPointerException e) {
			e.printStackTrace();
			Log.e("ERROR", "Did you set a QueryListener into ListContentActivity? this class needs QueryListener for work");
			throw e;
		}
	}
	
	private void init() throws NullPointerException {
		ApplicationProvider.setContentURI(getClassName());
		String query = tratarQuery(getQueryListener().initQuery());
		Bundle bundle = new Bundle();
		bundle.putString(QUERY, query);
		getSupportLoaderManager().initLoader(THE_LOADER, bundle, this).forceLoad();
	}

	private String tratarQuery(String query) {
		
		String firstBlock = query.substring(0, 6);
		
		String lastBlock = query.substring(6, query.length());
		
		query = firstBlock.concat(" 1 as _id,").concat(lastBlock);
		
		return query;
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		String query = "";
		if (args != null) {
			if (args.getString("query") != null) {
				query = args.getString("query");
			}
		}
		
		CursorLoader loader = new CursorLoader(this, ApplicationProvider.getContentURI(), null, query, null, null);
		getSupportLoaderManager().toString();
		loader.setUpdateThrottle(5);
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor list) {
		list.moveToFirst();
		
		ContentCursorAdapter mAdapter = new ContentCursorAdapter(this, list, this, getListLayoutId());
		
		getListView().setAdapter(mAdapter);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {		
		loader.reset();
		getListView().setAdapter(null);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		onItemClick();
	}
	

	public void onListItemClick(View view, int position, long id) {

	}

	
	private void onItemClick() {
		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				colorSelectedLine(position);
				onListItemClick(view, position, id);
			}
			
		});
	}
	
	
	public void search(String[] args) {
		String query = getQueryListener().onQueryChange(args);
		
		if (!isPositionSearch) {
			Bundle bundle = new Bundle();
			bundle.putString(QUERY, query);
			getSupportLoaderManager().restartLoader(THE_LOADER, bundle, ListContentActivity.this).forceLoad();
		} else {
			int position = 0;
			if (!args[0].equals("")) {
				position = getPosition(query);
			}
			getListView().setSelectionFromTop(position,0);
		}
	}

	
	public void enablePositionSearch(boolean enable) {
		this.isPositionSearch = enable;
	}
	
	
	private int getPosition(String queryFilter) {
		int position = 0;
			int indexFrom = queryFilter.indexOf("from");
			int indexWhere = queryFilter.indexOf("where");
			int indexOrder = queryFilter.indexOf("order");

			String from = queryFilter.substring(indexFrom, indexWhere);
			String where = queryFilter.substring(indexWhere, indexOrder);
			String order = queryFilter.substring(indexOrder, queryFilter.length());

			int indexLike = where.indexOf("like");
			String searchColum = where.substring(0, indexLike)
					.replace("where ", "");
			
			StringBuilder builder = new StringBuilder();
			
			
			builder.append("select count(0) ").append(" ")
					.append(from).append(" where ").append(searchColum)
					.append(" <= (").append("select ").append(searchColum)
					.append(" ").append(from).append(" ").append(where)
					.append(order).append(" limit 1").append(") ").append(order);
			
			
			Cursor cursor = null;
//			cursor = your dao consult
			cursor.moveToFirst();
			
			position = cursor.getInt(0);
		return position;
	}

	public String toStringItem(Object item) {
		return null;
	}

	public int getItemPositionForSection(int section) {
		return 0;
	}
	
	
	public ListView getListView() {
		if (listview == null) {
//			listview = (ListView) findViewById(R.id.listview); 
		}
		return listview;
	}
	
	public int getSelectionLineColor() { 
		return Color.parseColor("#87CEFF");
	}
	
	public void colorSelectedLine(int actualPosition) {
		this.lastPosition = this.actualPosition;
		this.actualPosition = actualPosition;

		View lView = null;
		if (this.lastPosition != -1) {
			lView = views.get(lastPosition);
			lView.setBackgroundColor(Color.WHITE);
		}

		View sView = views.get(actualPosition);
		sView.setBackgroundColor(Color.parseColor("#87CEFF"));
		selectedView = sView;

	}
	
	public void bindView(int position, View view, Cursor cursor) {
		if (!(actualPosition == position)) {
			view.setBackgroundColor(Color.WHITE);
		} else {
			view.setBackgroundColor(Color.parseColor("#87CEFF"));
		}

		views.put(position, view);
	}
	
	public View getSelectedView() {
		return selectedView;
	}
	
	/**
	 * comportamento padr�o de cada linha da lista
	 * @param view
	 */

	public abstract int getListLayoutId();
	
	public abstract View createViewHolder(View view);
	
	public abstract QueryListener getQueryListener();
	
	public abstract String getClassName();
	

}

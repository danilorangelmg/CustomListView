package com.example.dbprovider.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dbprovider.ListContentActivity;

public class ContentCursorAdapter extends BaseAdapter {

	private ListContentActivity activity;
	private LayoutInflater inflater;
	private int listLayoutId;
	private Context context;
	private Cursor cursor;


	public ContentCursorAdapter(Context context, Cursor c, ListContentActivity activity, int listId) {
		this.activity = activity;
		this.listLayoutId = listId;
		this.context = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.cursor = c;

	}

	public void bindView(int position, View view, Context context, Cursor cursor) {
		activity.bindView(position, view, cursor);
	}

	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return inflater.inflate(listLayoutId, null, false);
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView= newView(context, cursor, parent);
		} 

		if (!cursor.moveToPosition(position)) {
			throw new IllegalStateException("couldn't move cursor to position " + position);
		}

		convertView = activity.createViewHolder(convertView);
		bindView(position, convertView, context, cursor);
		return convertView;
	}

	@Override
	public int getCount() {
		return cursor.getCount();
	}

	@Override
	public Object getItem(int position) {
		cursor.moveToPosition(position);
		return cursor;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

//	@Override
//	public String toStringItem(Object item) {
//		return activity.toStringItem(item);
//	}
//
//	@Override
//	public int getItemPositionForSection(int section) {
//		return activity.getItemPositionForSection(section);
//	}
	
	public Cursor getCursor() {
		return cursor;
	}
}

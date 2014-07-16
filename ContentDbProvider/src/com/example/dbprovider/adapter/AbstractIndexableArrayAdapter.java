package com.example.dbprovider.adapter;

import android.widget.BaseAdapter;
import android.widget.SectionIndexer;

public abstract class AbstractIndexableArrayAdapter extends BaseAdapter implements SectionIndexer {


	private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String[] mSectionItens = {"#","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

	public AbstractIndexableArrayAdapter() {

	}

	public int getPositionForSection(int section) {
		return getItemPositionForSection(section);
	}

	public int getSectionForPosition(int position) {
		return 0;
	}

	public Object[] getSections() {
		String[] sections = new String[mSections.length()];
		for (int i = 0; i < mSections.length(); i++)
			sections[i] = String.valueOf(mSections.charAt(i));
		return sections;
	}


	public abstract String toStringItem(Object item);

	public abstract int getItemPositionForSection(int section);
	

	public int getItemPositionForSectionImpl(int section) {
//		// If there is no item for current section, previous section will be selected
//		for (int i = section; i >= 0; i--) {
//			for (int j = 0; j < getCount(); j++) {
//				if (i == 0) {
//					// For numeric section
//					for (int k = 0; k <= 9; k++) {
//						if (StringMatcher.match(String.valueOf(toStringItem(getItem(j)).charAt(0)), String.valueOf(k)))
//							return j;
//					}
//				} else {
//					if (StringMatcher.match(String.valueOf(toStringItem(getItem(j)).charAt(0)), String.valueOf(mSections.charAt(i))))
//						return j;
//				}
//			}
//		}
		
		return 0;
	}

	public String getValueForSection(int section) {
		return mSectionItens[section];
	}
	
}

package com.tcasper.maqualog.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class PagerAdapter extends FragmentPagerAdapter {
	
	private List<Fragment> fragments;
	
	public PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
		Log.d("PagerAdapter", "Entering PagerAdapter constructor");
	}
	
	@Override
	public int getCount() {
		Log.d("PagerAdapter", "Entering getCount(), returning " + this.fragments.size());
		return this.fragments.size();
	}
	
	@Override
	public Fragment getItem(int position) {
		Log.d("PagerAdapter", "Entering getItem(), returning position " + this.fragments.get(position));
		return this.fragments.get(position);
	}

}

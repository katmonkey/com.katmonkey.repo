package com.tcasper.maqualog.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tcasper.maqualog.fragment.AmmoniaFragment;

public class MaquaLogPagerAdapter extends FragmentStatePagerAdapter {
	
	public MaquaLogPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new AmmoniaFragment();
        Bundle args = new Bundle();
        args.putInt(AmmoniaFragment.ARG_OBJECT, i + 1); // Our object is just an integer :-P
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        // For this contrived example, we have a 100-object collection.
        return 100;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }

}

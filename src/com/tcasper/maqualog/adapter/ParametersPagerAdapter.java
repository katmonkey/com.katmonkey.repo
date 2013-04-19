package com.tcasper.maqualog.adapter;

import com.tcasper.maqualog.fragment.AlkilinityFragment;
import com.tcasper.maqualog.fragment.AmmoniaFragment;
import com.tcasper.maqualog.fragment.CalciumFragment;
import com.tcasper.maqualog.fragment.IodineFragment;
import com.tcasper.maqualog.fragment.MagnesiumFragment;
import com.tcasper.maqualog.fragment.NitrateFragment;
import com.tcasper.maqualog.fragment.NitriteFragment;
import com.tcasper.maqualog.fragment.PhosphateFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ParametersPagerAdapter extends FragmentPagerAdapter {
	
	public ParametersPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
    	Fragment fragment;
    	Bundle args;
        switch (i) {
            case 0:
            	return AmmoniaFragment.newInstance(i + 1);
            case 1:
                return NitriteFragment.newInstance(i + 1);
            case 2:
                return NitrateFragment.newInstance(i + 1);
            case 3:
            	return PhosphateFragment.newInstance(i + 1);
            case 4:
            	return AlkilinityFragment.newInstance(i + 1);
            case 5:
            	return CalciumFragment.newInstance(i + 1);
            case 6:
            	return MagnesiumFragment.newInstance(i + 1);
            case 7:
            	return IodineFragment.newInstance(i + 1);
            default:
                // The other sections of the app are dummy placeholders.
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Section " + (position + 1);
    }

}

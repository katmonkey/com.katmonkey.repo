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
            	fragment = new AmmoniaFragment();
                args = new Bundle();
                args.putInt(AmmoniaFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
            case 1:
                fragment = new NitriteFragment();
                args = new Bundle();
                args.putInt(NitriteFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
            case 2:
                fragment = new NitrateFragment();
                args = new Bundle();
                args.putInt(NitrateFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
            case 3:
            	fragment = new PhosphateFragment();
                args = new Bundle();
                args.putInt(PhosphateFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
            case 4:
            	fragment = new AlkilinityFragment();
                args = new Bundle();
                args.putInt(AlkilinityFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
            case 5:
            	fragment = new CalciumFragment();
                args = new Bundle();
                args.putInt(CalciumFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
            case 6:
            	fragment = new MagnesiumFragment();
                args = new Bundle();
                args.putInt(MagnesiumFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
            case 7:
            	fragment = new IodineFragment();
                args = new Bundle();
                args.putInt(IodineFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
            default:
                // The other sections of the app are dummy placeholders.
                fragment = new NitriteFragment();
                args = new Bundle();
                args.putInt(NitrateFragment.ARG_SECTION_NUMBER, i + 1);
                fragment.setArguments(args);
                return fragment;
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

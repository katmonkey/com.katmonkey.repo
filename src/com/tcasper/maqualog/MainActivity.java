package com.tcasper.maqualog;

import com.tcasper.maqualog.adapter.AppSectionsPagerAdapter;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private AppSectionsPagerAdapter appSectionsPagerAdapter;
	private ViewPager viewPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.d("MainActivity", "Entering onCreate!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  
        
        appSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
        
        final ActionBar actionBar = getActionBar();
        
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(appSectionsPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        	
        	@Override
        	public void onPageSelected(int position) {
        		actionBar.setSelectedNavigationItem(position);
        	}
        });
        
        for(int i = 0; i < appSectionsPagerAdapter.getCount(); i++) {
        	actionBar.addTab(actionBar.newTab().setText(appSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
        }
        
    }
    
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        viewPager.setCurrentItem(tab.getPosition());
    }
    
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

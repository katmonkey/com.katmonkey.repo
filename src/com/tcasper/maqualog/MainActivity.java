package com.tcasper.maqualog;

import java.util.ArrayList;

import com.tcasper.maqualog.adapter.ParametersPagerAdapter;
import com.tcasper.maqualog.util.MaquaLogConstants;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private static final String TAG = "MainActivity";
	private ParametersPagerAdapter parametersPagerAdapter;
	private ViewPager viewPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.d(TAG, "Entered onCreate!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        parametersPagerAdapter = new ParametersPagerAdapter(getSupportFragmentManager());
        
        final ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(parametersPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        	
        	@Override
        	public void onPageSelected(int position) {
        		Log.d("ViewPager.SimpleOnPageChangeListener", "Entered onPageSelected(), " +
        				"position parameter = " + position);
        		actionBar.setSelectedNavigationItem(position);
        	}
        });
        
        ArrayList<String> testNames = getTestNames();
        for(String testName : testNames) {
        	actionBar.addTab(actionBar.newTab().setText(testName).setTabListener(this));
        }    
    }
    
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    	Log.d(TAG, "Entered onTabSelected()");
    	// When the given tab is selected, switch to the corresponding page in the ViewPager.
        viewPager.setCurrentItem(tab.getPosition());
    }
    
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    	Log.d(TAG, "Entered onTabUnselected()");
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    	Log.d(TAG, "Entered onTabReselected()");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	Log.d(TAG, "Entered onCreateOptionsMenu()");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Entered onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Entered onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Entered onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Entered onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Entered onDestroy()");
    }
    
    private ArrayList<String> getTestNames() {
    	ArrayList<String> testNames = new ArrayList<String>();
    	testNames.add(MaquaLogConstants.AMMONIA);
        testNames.add(MaquaLogConstants.NITRITE);
        testNames.add(MaquaLogConstants.NITRATE);
        testNames.add(MaquaLogConstants.PHOSPHATE);
        testNames.add(MaquaLogConstants.ALKILINITY);
        testNames.add(MaquaLogConstants.CALCIUM);
        testNames.add(MaquaLogConstants.MAGNESIUM);
        testNames.add(MaquaLogConstants.IODINE);
        return testNames;
    }
    
}

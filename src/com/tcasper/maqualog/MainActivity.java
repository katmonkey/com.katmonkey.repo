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
	
	private ParametersPagerAdapter parametersPagerAdapter;
	private ViewPager viewPager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.d("MainActivity", "Entering onCreate!");
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
    /*
    public void createTableRow(View v) {
    	  TableLayout tl = (TableLayout) findViewById(R.id.spreadsheet);
    	  TableRow tr = new TableRow(this);
    	  LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
    	  tr.setLayoutParams(lp);

    	  TextView tvLeft = new TextView(this);
    	  tvLeft.setLayoutParams(lp);
    	  tvLeft.setBackgroundColor(Color.WHITE);
    	  tvLeft.setText("OMG");
    	  TextView tvCenter = new TextView(this);
    	  tvCenter.setLayoutParams(lp);
    	  tvCenter.setBackgroundColor(Color.WHITE);
    	  tvCenter.setText("It");
    	  TextView tvRight = new TextView(this);
    	  tvRight.setLayoutParams(lp);
    	  tvRight.setBackgroundColor(Color.WHITE);
    	  tvRight.setText("WORKED!!!");

    	  tr.addView(tvLeft);
    	  tr.addView(tvCenter);
    	  tr.addView(tvRight);

    	  tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
    	}
    	*/
}

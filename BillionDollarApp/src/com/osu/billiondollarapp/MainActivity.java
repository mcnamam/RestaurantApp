package com.osu.billiondollarapp;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); 
		//actionBar.setDisplayShowHomeEnabled(false);
		//actionBar.setDisplayShowTitleEnabled(false);
	    
	    Tab restaurantTab = actionBar.newTab()
                .setCustomView(R.layout.restaurant_tab)
                .setTabListener(new TabListener<RestaurantFragment>(
                        this, "Restaurants", RestaurantFragment.class));
	   
	    actionBar.addTab(restaurantTab);
	    
	    Tab statusTab = actionBar.newTab()
	    		.setCustomView(R.layout.wait_tab)
                .setTabListener(new TabListener<SeatingStatusFragment>(
                        this, "Status", SeatingStatusFragment.class));
	   
	    actionBar.addTab(statusTab);
	    Tab profileTab  = actionBar.newTab()
	    		.setCustomView(R.layout.profile_tab)
                .setTabListener(new TabListener<ProfileFragment>(
                        this, "Profile", ProfileFragment.class));
	   
	    actionBar.addTab(profileTab,true);
	    
	
		Log.d("MainActivity", "OnCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}
	
	@Override
	public void onPause() {
	    super.onPause(); 
	    Log.d("MainActivity","OnPause");
	}
	
	@Override
	public void onStart() {
	    super.onStart(); 

	    Log.d("MainActivity","OnStart");
	}
	
	@Override
	public void onStop() {
	    super.onStop(); 

	    Log.d("MainActivity","OnStop");
	}
	
	@Override
	public void onRestart() {
	    super.onRestart(); 

	    Log.d("MainActivity","OnRestart");
	}
	
	@Override
	public void onResume() {
	    super.onResume();

	    Log.d("MainActivity","OnResume");
	}
	
	
	
	public static class TabListener<T extends Fragment> implements ActionBar.TabListener
	{
		 private Fragment mFragment;
		 private final Activity mActivity;
		 private final String mTag;
		 private final Class<T> mClass;
		    
		 public TabListener(Activity activity, String tag, Class<T> clz) {
		        mActivity = activity;
		        mTag = tag;
		        mClass = clz;
		    }
		 
		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab arg0, FragmentTransaction ft) {
			 // Check if the fragment is already initialized
	        if (mFragment == null) {
	            // If not, instantiate and add it to the activity
	            mFragment = Fragment.instantiate(mActivity, mClass.getName());
	            ft.add(android.R.id.content, mFragment, mTag);
	        } else {
	            // If it exists, simply attach it in order to show it
	            ft.attach(mFragment);
	        }			
		}

		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction ft) {
			if (mFragment != null) {
	            // Detach the fragment, because another one is being attached
	            ft.detach(mFragment);
	        }			
		}
	}
}

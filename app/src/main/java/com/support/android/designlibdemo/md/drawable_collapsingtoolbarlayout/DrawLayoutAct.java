/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.support.android.designlibdemo.md.drawable_collapsingtoolbarlayout;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.*;
import com.support.android.designlibdemo.R;
import java.util.ArrayList;
import java.util.List;

/**
 https://www.jianshu.com/p/17b6641b4891
 https://www.jianshu.com/p/fde38f367019 tablayout */
public class DrawLayoutAct extends AppCompatActivity
{
	private DrawerLayout mDrawerLayout;
	TabLayout tabLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawlayout_main);
		Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		final ActionBar ab=getSupportActionBar();
		ab.setHomeAsUpIndicator(R.drawable.ic_menu);
		ab.setDisplayHomeAsUpEnabled(true);
		mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
		final NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
		final CoordinatorLayout coordinatorLayout=findViewById(R.id.main_content);
		mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener()
		{
			@Override
			public void onDrawerSlide(@NonNull View drawerView, float slideOffset){
				//获取屏幕的宽高
				WindowManager manager=(WindowManager)getSystemService(Context.WINDOW_SERVICE);
				Display display=manager.getDefaultDisplay();
				Point point=new Point();
				display.getSize(point);
				//设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
				coordinatorLayout.layout(navigationView.getRight(), 0,
						navigationView.getRight()+point.x, point.y);
			}
			
			@Override
			public void onDrawerOpened(@NonNull View drawerView){
				// 打开手势滑动
			}
			
			@Override
			public void onDrawerClosed(@NonNull View drawerView){
				// 关闭手势滑动
			}
			
			@Override
			public void onDrawerStateChanged(int newState){
			}
		});
		if(navigationView!=null){
			setupDrawerContent(navigationView);
		}
		ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
		if(viewPager!=null){
			setupViewPager(viewPager);
		}
		FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view){
				Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
						.setAction("Action", null)
						.show();
			}
		});
		tabLayout=(TabLayout)findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(viewPager);
		tabLayout.post(new Runnable()
		{
			@Override
			public void run(){
				IndicatorLineUtil.setIndicator(tabLayout, 40, 40);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.sample_actions, menu);
		return true;
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		switch(AppCompatDelegate.getDefaultNightMode()){
		case AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM:
			menu.findItem(R.id.menu_night_mode_system).setChecked(true);
			break;
		case AppCompatDelegate.MODE_NIGHT_AUTO:
			menu.findItem(R.id.menu_night_mode_auto).setChecked(true);
			break;
		case AppCompatDelegate.MODE_NIGHT_YES:
			menu.findItem(R.id.menu_night_mode_night).setChecked(true);
			break;
		case AppCompatDelegate.MODE_NIGHT_NO:
			menu.findItem(R.id.menu_night_mode_day).setChecked(true);
			break;
		}
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case android.R.id.home:
			mDrawerLayout.openDrawer(GravityCompat.START);
			//return true;
		case R.id.menu_night_mode_system:
			setNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
			break;
		case R.id.menu_night_mode_day:
			setNightMode(AppCompatDelegate.MODE_NIGHT_NO);
			break;
		case R.id.menu_night_mode_night:
			setNightMode(AppCompatDelegate.MODE_NIGHT_YES);
			break;
		case R.id.menu_night_mode_auto:
			setNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void setNightMode(@AppCompatDelegate.NightMode int nightMode){
		AppCompatDelegate.setDefaultNightMode(nightMode);
		if(Build.VERSION.SDK_INT>=11){
			recreate();
		}
	}
	
	private void setupViewPager(ViewPager viewPager){
		Adapter adapter=new Adapter(getSupportFragmentManager());
		adapter.addFragment(new CheeseListFragment(), "bruce1");
		adapter.addFragment(new CheeseListFragment(), "bruce2");
		adapter.addFragment(new CheeseListFragment(), "bruce3");
		viewPager.setAdapter(adapter);
	}
	
	private void setupDrawerContent(NavigationView navigationView){
		navigationView.setNavigationItemSelectedListener(
				new NavigationView.OnNavigationItemSelectedListener()
				{
					@Override
					public boolean onNavigationItemSelected(MenuItem menuItem){
						menuItem.setChecked(true);
						//mDrawerLayout.closeDrawers();
						//mDrawerLayout.closeDrawer(GravityCompat.START);
						return true;
					}
				});
	}
	
	final List<String> mFragmentTitles=new ArrayList<>();
	
	public class Adapter extends FragmentPagerAdapter
	{
		private final List<Fragment> mFragments=new ArrayList<>();
		
		public Adapter(FragmentManager fm){
			super(fm);
		}
		
		public void addFragment(Fragment fragment, String title){
			mFragments.add(fragment);
			mFragmentTitles.add(title);
		}
		
		@Override
		public Fragment getItem(int position){
			return mFragments.get(position);
		}
		
		@Override
		public int getCount(){
			return mFragments.size();
		}
		
		@Override
		public CharSequence getPageTitle(int position){
			return mFragmentTitles.get(position);
		}
	}
	//加入tablayout图标
	
	///**
	// 设置自定义位置图标
	// */
	//private void setCustomIcon(){
	//	for(int i=0; i<mFragmentTitles.size(); i++){
	//		tabLayout.addTab(tabLayout.newTab());
	//	}
	//	for(int i=0; i<mFragmentTitles.size(); i++){
	//		tabLayout.getTabAt(i).setCustomView(makeTabView(i));
	//	}
	//}
	//
	///**
	// 引入布局设置图标和标题
	// */
	//private View makeTabView(int position){
	//	View tabView=LayoutInflater.from(this).inflate(R.layout.tab_text_icon, null);
	//	TextView textView=tabView.findViewById(R.id.textview);
	//	ImageView imageView=tabView.findViewById(R.id.imageview);
	//	textView.setText(titles[position]);
	//	imageView.setImageResource(pics[position]);
	//	return tabView;
	//}
}

package com.support.android.designlibdemo.md.bottomnavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ${bruce}
 * @project: cheesesquare-master
 * @package: com.support.android.designlibdemo.md.bottomnavigation
 * @description:
 * @date: 2018/12/6 0006  
 * @time: 下午 3:31
 */
public class ViewPagerAdapter extends FragmentPagerAdapter
{
	
	private final List<Fragment> mFragmentList = new ArrayList<>();
	
	public ViewPagerAdapter(FragmentManager manager) {
		super(manager);
	}
	
	@Override
	public Fragment getItem(int position) {
		return mFragmentList.get(position);
	}
	
	@Override
	public int getCount() {
		return mFragmentList.size();
	}
	
	public void addFragment(Fragment fragment) {
		mFragmentList.add(fragment);
	}
	
}

package com.support.android.designlibdemo.md.Palette;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author: ${bruce}
 * @project: cheesesquare-master
 * @package: com.support.android.designlibdemo.md.Palette
 * @description:
 * @date: 2018/12/7 0007  
 * @time: 上午 10:27
 */
public class PaletteViewPagerAdapter extends FragmentPagerAdapter
{
	final int PAGE_COUNT=5;
	private String tabTitles[]=new String[]{"主页", "分享", "收藏", "关注", "微博"};
	private Context context;
	
	public PaletteViewPagerAdapter(FragmentManager fm, Context context){
		super(fm);
		this.context=context;
	}
	
	@Override
	public Fragment getItem(int position){
		return PaletteFragment.newInstance(position);
	}
	
	@Override
	public int getCount(){
		return PAGE_COUNT;
	}
	
	@Override
	public CharSequence getPageTitle(int position){
		return tabTitles[position];
	}
}

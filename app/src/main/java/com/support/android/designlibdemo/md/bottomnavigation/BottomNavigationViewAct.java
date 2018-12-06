package com.support.android.designlibdemo.md.bottomnavigation;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.support.android.designlibdemo.R;

/**
 * @author: ${bruce}
 * @project: cheesesquare-master
 * @package: com.support.android.designlibdemo.md.bottomnavigationview
 * @description:
 * @date: 2018/12/6 0006  
 * @time: 下午 3:20
 */
public class BottomNavigationViewAct extends AppCompatActivity
{
	
	private ViewPager viewPager;
	private MenuItem menuItem;
	private BottomNavigationView bottomNavigationView;
	
	@RequiresApi(api=Build.VERSION_CODES.KITKAT)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_bottomnavigation);
		
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
		//默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
		BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
		bottomNavigationView.setOnNavigationItemSelectedListener(
				new BottomNavigationView.OnNavigationItemSelectedListener() {
					@Override
					public boolean onNavigationItemSelected(@NonNull MenuItem item) {
						switch (item.getItemId()) {
						case R.id.item_news:
							viewPager.setCurrentItem(0);
							break;
						case R.id.item_lib:
							viewPager.setCurrentItem(1);
							break;
						case R.id.item_find:
							viewPager.setCurrentItem(2);
							break;
						case R.id.item_more:
							viewPager.setCurrentItem(3);
							break;
						}
						return false;
					}
				});
		
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			
			}
			
			@Override
			public void onPageSelected(int position) {
				if (menuItem != null) {
					menuItem.setChecked(false);
				} else {
					bottomNavigationView.getMenu().getItem(0).setChecked(false);
				}
				menuItem = bottomNavigationView.getMenu().getItem(position);
				menuItem.setChecked(true);
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
		
		//禁止ViewPager滑动
		//        viewPager.setOnTouchListener(new View.OnTouchListener() {
		//            @Override
		//            public boolean onTouch(View v, MotionEvent event) {
		//                return true;
		//            }
		//        });
		
		setupViewPager(viewPager);
	}
	
	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		
		adapter.addFragment(BaseFragment.newInstance("新闻"));
		adapter.addFragment(BaseFragment.newInstance("图书"));
		adapter.addFragment(BaseFragment.newInstance("发现"));
		adapter.addFragment(BaseFragment.newInstance("更多"));
		viewPager.setAdapter(adapter);
	}
	
}

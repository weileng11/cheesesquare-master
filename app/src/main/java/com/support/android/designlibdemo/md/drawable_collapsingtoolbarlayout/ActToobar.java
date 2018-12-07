package com.support.android.designlibdemo.md.drawable_collapsingtoolbarlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.support.android.designlibdemo.R;

/**
 * @author: ${bruce}
 * @project: cheesesquare-master
 * @package: com.support.android.designlibdemo.md.drawable_collapsingtoolbarlayout
 * @description:
 * @date: 2018/12/7 0007  
 * @time: 上午 10:11
 */
public class ActToobar extends AppCompatActivity
{
	private Toolbar mNormalToolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_toobar);
		mNormalToolbar= (Toolbar) findViewById(R.id.toolbar);
		
		initToolbar();
		
	}
	
	private void initToolbar() {
		//设置menu
		mNormalToolbar.inflateMenu(R.menu.menu_icon);
		//设置menu的点击事件
		mNormalToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()){
				case R.id.share:
					Toast.makeText(ActToobar.this,"分享",Toast.LENGTH_SHORT).show();
					break;
				case R.id.happy:
					Toast.makeText(ActToobar.this,"开心",Toast.LENGTH_SHORT).show();
					break;
				case R.id.setting:
					Toast.makeText(ActToobar.this,"设置",Toast.LENGTH_SHORT).show();
					break;
				}
				return false;
			}
		});
		//设置左侧NavigationIcon点击事件
		mNormalToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(ActToobar.this, "点击了左侧按钮", Toast.LENGTH_SHORT).show();
			}
		});
	}
}


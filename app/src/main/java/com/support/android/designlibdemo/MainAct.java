package com.support.android.designlibdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.support.android.designlibdemo.md.bottomnavigation.BottomNavigationViewAct;
import com.support.android.designlibdemo.md.cardview.CradViewAct;
import com.support.android.designlibdemo.md.drawable_collapsingtoolbarlayout.DrawLayoutAct;
import com.support.android.designlibdemo.md.textinputlayout.ActTextInputLayout;

/**
 * @author: ${bruce}
 * @project: cheesesquare-master
 * @package: com.support.android.designlibdemo
 * @description:
 * @date: 2018/12/6 0006  
 * @time: 下午 3:37
 */
public class MainAct extends AppCompatActivity implements View.OnClickListener
{
	 @Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actmain);
		
		 findViewById(R.id.button0).setOnClickListener(this);
		 findViewById(R.id.button1).setOnClickListener(this);
		 findViewById(R.id.button2).setOnClickListener(this);
		 findViewById(R.id.button3).setOnClickListener(this);
		 findViewById(R.id.button4).setOnClickListener(this);
		 findViewById(R.id.button5).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		if (view.getId()==R.id.button0) {
			startActivity(new Intent(this,BottomNavigationViewAct.class));
		} else if (view.getId()==R.id.button1) {
			startActivity(new Intent(this,DrawLayoutAct.class));
		} else if (view.getId()==R.id.button2) {
			startActivity(new Intent(this,CradViewAct.class));
		}else if (view.getId()==R.id.button3) {
			startActivity(new Intent(this,ActTextInputLayout.class));
		}else if (view.getId()==R.id.button4) {
		}else if (view.getId()==R.id.button5) {
		}
	}
}

package com.support.android.designlibdemo.md.cardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.support.android.designlibdemo.R;

/**
 * @author: ${bruce}
 * @project: cheesesquare-master
 * @package: com.support.android.designlibdemo.md.cardview
 * @description:  https://www.jianshu.com/p/63751afe368b
 * @date: 2018/12/6 0006  
 * @time: 下午 5:18
 */
public class CradViewAct extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_cardview);
		
		/*
		* app:cardBackgroundColor这是设置背景颜色
app:cardCornerRadius这是设置圆角大小
app:cardElevation这是设置阴影（z轴），具体效果见下面
app:contentPadding 设置内容的padding CardView子布局与CardView边界
app:contentPaddingLeft 设置内容的左padding
app:contentPaddingTop 设置内容的上padding
app:contentPaddingRight 设置内容的右padding
app:contentPaddingBottom 设置内容的底padding
app:cardUseCompatPadding 是否使用CompatPadding， 官方说是设置内边距，个人感觉不到什么，具体效果见下面
app:cardPreventCornerOverlap 是否使用PreventCornerOverlap，设置内边距（API20及以下中），通常该属性为了避免内容和边角的重叠
		* */
	}
}

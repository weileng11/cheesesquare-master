package com.support.android.designlibdemo.md.Palette;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.*;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.support.android.designlibdemo.R;

/**
 * @author: ${bruce}
 * @project: cheesesquare-master
 * @package: com.support.android.designlibdemo.md.Palette
 * @description:
 * @date: 2018/12/7 0007  
 * @time: 上午 10:28
 */
public class PaletteFragment extends Fragment
{
	private static final String ARG_POSITION="position";
	private int position;
	private static final int[] drawables={
			R.mipmap.one, R.mipmap.two, R.mipmap.four, R.mipmap.three, R.mipmap.five
	};
	
	public static PaletteFragment newInstance(int position){
		PaletteFragment f=new PaletteFragment();
		Bundle b=new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		position=getArguments().getInt(ARG_POSITION);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
		FrameLayout fl=new FrameLayout(getActivity());
		fl.setLayoutParams(params);
		fl.setBackgroundResource(drawables[position]);
		final int margin=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8,
				getResources().getDisplayMetrics());
		TextView v=new TextView(getActivity());
		params.setMargins(margin, margin, margin, margin);
		v.setLayoutParams(params);
		v.setLayoutParams(params);
		v.setGravity(Gravity.BOTTOM);
		v.setText("CARD "+(position+1));
		fl.addView(v);
		return fl;
	}
	
	/**
	 提供当前Fragment的主色调的Bitmap对象,供Palette解析颜色
	 */
	public static int getBackgroundBitmapPosition(int selectViewPagerItem){
		return drawables[selectViewPagerItem];
	}
}

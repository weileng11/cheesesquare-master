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

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.support.android.designlibdemo.R;

/**
 https://blog.csdn.net/u012124438/article/details/56701641
 https://blog.csdn.net/xiaoqiang_0719/article/details/74942269
 https://blog.csdn.net/victor_fang/article/details/54691957
 https://blog.csdn.net/da_caoyuan/article/details/79557704
 */
public class CheeseDetailAct extends AppCompatActivity {
	
	// 控制ToolBar的变量
	private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
	private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
	
	private static final int ALPHA_ANIMATIONS_DURATION = 200;
	
	private boolean mIsTheTitleVisible = false;
	private boolean mIsTheTitleContainerVisible = true;
	
	public static final String EXTRA_NAME = "cheese_name";
	
    ImageView imageView;
	Toolbar toolbar;
	AppBarLayout mAppBarLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
	    mAppBarLayout=findViewById(R.id.appbar);

        Intent intent = getIntent();
        final String cheeseName = intent.getStringExtra(EXTRA_NAME);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(cheeseName);

        loadBackdrop();
	
        //设置自动滑动的动画效果
	    initParallaxValues(toolbar);
	
	    // AppBar的监听(针对于toobar)
	    mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
		    @Override
		    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
			    int maxScroll = appBarLayout.getTotalScrollRange();
			    float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
			    handleAlphaOnTitle(percentage);
			    handleToolbarTitleVisibility(percentage);
		    }
	    });
	
    }

    private void loadBackdrop() {
        imageView = findViewById(R.id.backdrop);
        Glide.with(this).load(Cheeses.getRandomCheeseDrawable()).apply(RequestOptions.centerCropTransform()).into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }
    
    //设置自动滑动的动画效果
	private void initParallaxValues(Toolbar toolbar) {
		CollapsingToolbarLayout.LayoutParams petDetailsLp =
				(CollapsingToolbarLayout.LayoutParams) imageView.getLayoutParams();
		
		CollapsingToolbarLayout.LayoutParams petBackgroundLp =
				(CollapsingToolbarLayout.LayoutParams) toolbar.getLayoutParams();
		
		petDetailsLp.setParallaxMultiplier(0.9f);
		petBackgroundLp.setParallaxMultiplier(0.3f);
		
		imageView.setLayoutParams(petDetailsLp);
		toolbar.setLayoutParams(petBackgroundLp);
	}
	
	
	// 处理ToolBar的显示
	private void handleToolbarTitleVisibility(float percentage) {
		if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {
			if (!mIsTheTitleVisible) {
				startAlphaAnimation(toolbar, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
				mIsTheTitleVisible = true;
			}
		} else {
			if (mIsTheTitleVisible) {
				startAlphaAnimation(toolbar, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
				mIsTheTitleVisible = false;
			}
		}
	}
	
	// 控制Title的显示
	private void handleAlphaOnTitle(float percentage) {
		if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
			if (mIsTheTitleContainerVisible) {
				startAlphaAnimation(toolbar, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
				mIsTheTitleContainerVisible = false;
			}
		} else {
			if (!mIsTheTitleContainerVisible) {
				startAlphaAnimation(toolbar, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
				mIsTheTitleContainerVisible = true;
			}
		}
	}
	
	// 设置渐变的动画
	public static void startAlphaAnimation(View v, long duration, int visibility) {
		AlphaAnimation alphaAnimation = (visibility==View.VISIBLE)
				? new AlphaAnimation(0f, 1f)
				: new AlphaAnimation(1f, 0f);
		
		alphaAnimation.setDuration(duration);
		alphaAnimation.setFillAfter(true);
		v.startAnimation(alphaAnimation);
	}
}

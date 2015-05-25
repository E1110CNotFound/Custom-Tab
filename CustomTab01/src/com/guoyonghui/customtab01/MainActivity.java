package com.guoyonghui.customtab01;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private ViewPager mViewPager;

	private TextView mTab1;

	private TextView mTab2;

	private TextView mTab3;

	private TextView mTab4;

	private PagerAdapter mAdapter;
	
	private List<View> mViews = new ArrayList<View>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		
		initEvents();
	}

	private void initEvents() {
		mTab1.setOnClickListener(this);
		mTab2.setOnClickListener(this);
		mTab3.setOnClickListener(this);
		mTab4.setOnClickListener(this);
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				reset();
				switch (mViewPager.getCurrentItem()) {
				case 0:
					mTab1.setTextColor(getResources().getColor(android.R.color.darker_gray));
					break;
				case 1:
					mTab2.setTextColor(getResources().getColor(android.R.color.darker_gray));
					break;
				case 2:
					mTab3.setTextColor(getResources().getColor(android.R.color.darker_gray));
					break;
				case 3:
					mTab4.setTextColor(getResources().getColor(android.R.color.darker_gray));
					break;

				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}

	private void initView() {
		mViewPager = (ViewPager)findViewById(R.id.viewpager);
		
		mTab1 = (TextView)findViewById(R.id.tab_1);
		mTab2 = (TextView)findViewById(R.id.tab_2);
		mTab3 = (TextView)findViewById(R.id.tab_3);
		mTab4 = (TextView)findViewById(R.id.tab_4);
		
		LayoutInflater inflater = LayoutInflater.from(this);
		View tab1 = inflater.inflate(R.layout.tab1, null);
		View tab2 = inflater.inflate(R.layout.tab2, null);
		View tab3 = inflater.inflate(R.layout.tab3, null);
		View tab4 = inflater.inflate(R.layout.tab4, null);

		mViews.add(tab1);
		mViews.add(tab2);
		mViews.add(tab3);
		mViews.add(tab4);
		
		mAdapter = new PagerAdapter() {
			
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(mViews.get(position));
			}
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				return mViews.size();
			}
		};
		
		mViewPager.setAdapter(mAdapter);
	}

	private void reset() {
		mTab1.setTextColor(getResources().getColor(android.R.color.white));
		mTab2.setTextColor(getResources().getColor(android.R.color.white));
		mTab3.setTextColor(getResources().getColor(android.R.color.white));
		mTab4.setTextColor(getResources().getColor(android.R.color.white));
	}

	@Override
	public void onClick(View v) {
		reset();
		switch (v.getId()) {
		case R.id.tab_1:
			mViewPager.setCurrentItem(0);
			mTab1.setTextColor(getResources().getColor(android.R.color.darker_gray));
			break;
		case R.id.tab_2:
			mViewPager.setCurrentItem(1);
			mTab2.setTextColor(getResources().getColor(android.R.color.darker_gray));
			break;
		case R.id.tab_3:
			mViewPager.setCurrentItem(2);
			mTab3.setTextColor(getResources().getColor(android.R.color.darker_gray));
			break;
		case R.id.tab_4:
			mViewPager.setCurrentItem(3);
			mTab4.setTextColor(getResources().getColor(android.R.color.darker_gray));
			break;

		default:
			break;
		}
	}
	
}

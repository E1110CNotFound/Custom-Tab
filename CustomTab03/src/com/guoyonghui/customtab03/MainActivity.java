package com.guoyonghui.customtab03;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private ViewPager mViewPager;

	private TextView mTab1;

	private TextView mTab2;

	private TextView mTab3;

	private TextView mTab4;
	
	private Fragment mTab1Fragment;
	
	private Fragment mTab2Fragment;
	
	private Fragment mTab3Fragment;
	
	private Fragment mTab4Fragment;
	
	private FragmentPagerAdapter mAdapter;
	
	private List<Fragment> mFragments = new ArrayList<Fragment>(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		
		initEvents();
		
		setSelect(1);
	}
	
	private void initEvents() {
		mTab1.setOnClickListener(this);
		mTab2.setOnClickListener(this);
		mTab3.setOnClickListener(this);
		mTab4.setOnClickListener(this);
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				int currentItem = mViewPager.getCurrentItem();
				setTab(currentItem);
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

		mTab1Fragment = new Tab1Fragment();
		mTab2Fragment = new Tab2Fragment();
		mTab3Fragment = new Tab3Fragment();
		mTab4Fragment = new Tab4Fragment();
		
		mFragments.add(mTab1Fragment);
		mFragments.add(mTab2Fragment);
		mFragments.add(mTab3Fragment);
		mFragments.add(mTab4Fragment);
		
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				return mFragments.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				return mFragments.get(arg0);
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
	
	private void setSelect(int index) {
		setTab(index);
		mViewPager.setCurrentItem(index);
	}

	private void setTab(int index) {
		reset();
		switch (index) {
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
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab_1:
			setSelect(0);
			break;
		case R.id.tab_2:
			setSelect(1);
			break;
		case R.id.tab_3:
			setSelect(2);
			break;
		case R.id.tab_4:
			setSelect(3);
			break;

		default:
			break;
		}
	}

}

package com.guoyonghui.customtab02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private TextView mTab1;

	private TextView mTab2;

	private TextView mTab3;

	private TextView mTab4;
	
	private Fragment mTab1Fragment;
	
	private Fragment mTab2Fragment;
	
	private Fragment mTab3Fragment;
	
	private Fragment mTab4Fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		
		initEvents();
		
		setSelect(0);
	}
	
	private void initEvents() {
		mTab1.setOnClickListener(this);
		mTab2.setOnClickListener(this);
		mTab3.setOnClickListener(this);
		mTab4.setOnClickListener(this);
	}
		
	private void initView() {
		mTab1 = (TextView)findViewById(R.id.tab_1);
		mTab2 = (TextView)findViewById(R.id.tab_2);
		mTab3 = (TextView)findViewById(R.id.tab_3);
		mTab4 = (TextView)findViewById(R.id.tab_4);
	}
	
	private void reset(FragmentTransaction transaction) {
		mTab1.setTextColor(getResources().getColor(android.R.color.white));
		mTab2.setTextColor(getResources().getColor(android.R.color.white));
		mTab3.setTextColor(getResources().getColor(android.R.color.white));
		mTab4.setTextColor(getResources().getColor(android.R.color.white));

		if(mTab1Fragment != null) {
			transaction.hide(mTab1Fragment);
		}
		if(mTab2Fragment != null) {
			transaction.hide(mTab2Fragment);
		}
		if(mTab3Fragment != null) {
			transaction.hide(mTab3Fragment);
		}
		if(mTab4Fragment != null) {
			transaction.hide(mTab4Fragment);
		}
	}
	
	private void setSelect(int index) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		reset(transaction);
		switch (index) {
		case 0:
			if(mTab1Fragment == null) {
				mTab1Fragment = new Tab1Fragment();
				transaction.add(R.id.fragment_container, mTab1Fragment);
			}
			transaction.show(mTab1Fragment);
			mTab1.setTextColor(getResources().getColor(android.R.color.darker_gray));
			break;
		case 1:
			if(mTab2Fragment == null) {
				mTab2Fragment = new Tab2Fragment();
				transaction.add(R.id.fragment_container, mTab2Fragment);
			}
			transaction.show(mTab2Fragment);
			mTab2.setTextColor(getResources().getColor(android.R.color.darker_gray));
			break;
		case 2:
			if(mTab3Fragment == null) {
				mTab3Fragment = new Tab3Fragment();
				transaction.add(R.id.fragment_container, mTab3Fragment);
			}
			transaction.show(mTab3Fragment);
			mTab3.setTextColor(getResources().getColor(android.R.color.darker_gray));
			break;
		case 3:
			if(mTab4Fragment == null) {
				mTab4Fragment = new Tab4Fragment();
				transaction.add(R.id.fragment_container, mTab4Fragment);
			}
			transaction.show(mTab4Fragment);
			mTab4.setTextColor(getResources().getColor(android.R.color.darker_gray));
			break;

		default:
			break;
		}
		transaction.commit();
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

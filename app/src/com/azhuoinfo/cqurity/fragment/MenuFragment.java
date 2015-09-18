package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.azhuoinfo.cqurity.AccountVerify;
import com.azhuoinfo.cqurity.ModuleMenuIDS;

import com.azhuoinfo.cqurity.R;
import mobi.cangol.mobile.base.BaseMenuFragment;
import mobi.cangol.mobile.base.FragmentInfo;
import mobi.cangol.mobile.service.AppService;
import mobi.cangol.mobile.service.global.GlobalData;

public class MenuFragment extends BaseMenuFragment {
	public TextView mHomeTextView;
	public TextView mBrandTextView;
	public TextView mMineTextView;
	public TextView mCategoryextView;
	
	private AccountVerify mAccountVerify;
	private GlobalData mGlobalData;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAccountVerify = AccountVerify.getInstance(getActivity());
		mGlobalData=(GlobalData) this.getAppService(AppService.GLOBAL_DATA);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_menu, container, false);
		return v;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		findViews(view);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initViews(savedInstanceState);
		initData(savedInstanceState);
		
	}
	@Override
	protected void findViews(View v) {
		mHomeTextView = (TextView) v.findViewById(R.id.textview_menu_home);
		mBrandTextView = (TextView) v.findViewById(R.id.textview_menu_brand);
		mMineTextView = (TextView) v.findViewById(R.id.textview_menu_mine);
		mCategoryextView= (TextView) v.findViewById(R.id.textview_menu_category);
		
	}

	@Override
	protected void initViews(Bundle savedInstanceState) {
		mCategoryextView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				setContentFragment(MineFragment.class, "MineFragment", null,ModuleMenuIDS.MODULE_CATEGORY);
			}
		
		});
		mHomeTextView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				setContentFragment(HomeFragment.class, "HomeFragment", null,ModuleMenuIDS.MODULE_HOME);
			}
		
		});
		mBrandTextView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//setContentFragment(BrandFragment.class, "BrandFragment", null,ModuleMenuIDS.MODULE_BRAND);
			}
		
		});
		mMineTextView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//setContentFragment(MineFragment.class, "MineFragment", null,ModuleMenuIDS.MODULE_MINE);
			}
		
		});
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		if(savedInstanceState!=null){
			updateFocus(this.getCurrentModuleId());
		}else{
			this.setCurrentModuleId(this.getCurrentModuleId());
		}
	}
	@Override
	protected void onContentChange(int moduleId) {
		if(this.getView()!=null){
			updateFocus(moduleId);
		}
	}
	
	protected void updateFocus(int moduleId) {
		switch (moduleId) {
		case ModuleMenuIDS.MODULE_CATEGORY:
			mCategoryextView.setSelected(true);
			mHomeTextView.setSelected(false);
			mBrandTextView.setSelected(false);
			mMineTextView.setSelected(false);
			break;
		case ModuleMenuIDS.MODULE_HOME:
			mCategoryextView.setSelected(false);
			mHomeTextView.setSelected(true);
			mBrandTextView.setSelected(false);
			mMineTextView.setSelected(false);
			break;
		case ModuleMenuIDS.MODULE_BRAND:
			mCategoryextView.setSelected(false);
			mHomeTextView.setSelected(false);
			mBrandTextView.setSelected(true);
			mMineTextView.setSelected(false);
			break;
		case ModuleMenuIDS.MODULE_MINE:
			mCategoryextView.setSelected(false);
			mHomeTextView.setSelected(false);
			mBrandTextView.setSelected(false);
			mMineTextView.setSelected(true);
			break;
		}
	}
	@Override
	protected FragmentInfo getNavigtionUpToFragment() {
		return null;
	}
	
	@Override
	protected void onClosed() {

	}

	@Override
	protected void onOpen() {

	}
}

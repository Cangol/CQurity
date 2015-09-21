package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.azhuoinfo.cqurity.AccountVerify;

import com.azhuoinfo.cqurity.R;

import mobi.cangol.mobile.actionbar.ActionMenu;
import mobi.cangol.mobile.actionbar.ActionMenuItem;
import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

public class MineFragment extends BaseContentFragment {
	private AccountVerify mAccountVerify;
	private TextView mNew,mExplore;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAccountVerify = AccountVerify.getInstance(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_mine, container, false);
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
	protected void findViews(View view) {
		mNew = (TextView) view.findViewById(R.id.textview_mine_new);
		mExplore = (TextView) view.findViewById(R.id.textview_mine_explore);
	}
	
	@Override
	protected void initViews(Bundle savedInstanceState) {
		this.setTitle(R.string.title_mine);

		/**
		 * 新增项目的事件监听
		 */
		mNew.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				replaceFragment(NewProjectFragment.class,"NewProjectFragment",null);
			}
		});
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		
	}

	@Override
	protected boolean onMenuActionCreated(ActionMenu actionMenu) {
		actionMenu.add(new ActionMenuItem(1,null,R.drawable.ic_user_default,1));
		return super.onMenuActionCreated(actionMenu);
	}

	@Override
	protected boolean onMenuActionSelected(ActionMenuItem action) {
		replaceFragment(SettingsFragment.class,"SettingsFragment",null);
		return super.onMenuActionSelected(action);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected FragmentInfo getNavigtionUpToFragment() {
		return null;
	}

	@Override
	public boolean isCleanStack() {
		return true;
	}

}

package com.azhuoinfo.cqurity.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.azhuoinfo.cqurity.AccountVerify;
import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.activity.DialogActivity;
import com.azhuoinfo.cqurity.view.CommonDialog;

import java.security.AccessController;

import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

public class ProjectFragment extends BaseContentFragment implements View.OnClickListener {
	private AccountVerify mAccountVerify;
	private Button mStaff,mEcomm;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAccountVerify = AccountVerify.getInstance(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_tab_project, container, false);

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
		mStaff = (Button) view.findViewById(R.id.btn_staff);
		mEcomm = (Button) view.findViewById(R.id.btn_ecommerce);
	}
	
	@Override
	protected void initViews(Bundle savedInstanceState) {

		mStaff.setOnClickListener(this);
		mEcomm.setOnClickListener(this);
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
		
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
		return false;
	}

	@Override
	public void onClick(View v) {
		startActivity(new Intent(getActivity().getBaseContext(),DialogActivity.class));
	}
}

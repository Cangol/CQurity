package com.azhuoinfo.cqurity.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.azhuoinfo.cqurity.AccountVerify;
import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.activity.DialogActivity;
import com.azhuoinfo.cqurity.fragment.adapter.ProjectAdapter;
import com.azhuoinfo.cqurity.view.CommonDialog;

import java.security.AccessController;

import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

public class ProjectFragment extends BaseContentFragment implements View.OnClickListener {
	private AccountVerify mAccountVerify;
	private Button mStaff,mEcomm;
	private ListView mList;
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
		View v = view.findViewById(R.id.include_project);
		mList = (ListView) v.findViewById(R.id.listView);
		mList.setDividerHeight(30);
		ProjectAdapter adapter = new ProjectAdapter(getActivity().getApplicationContext());
		mList.setAdapter(adapter);
	}
	
	@Override
	protected void initViews(Bundle savedInstanceState) {

		mStaff.setOnClickListener(this);
		mEcomm.setOnClickListener(this);

		mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				view.setBackgroundColor(Color.GRAY);
				replaceParentFragment(ProjectAdminFragment.class,"P111",null);
			}
		});
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
		return true;
	}

	@Override
	public void onClick(View v) {
		startActivity(new Intent(getActivity().getBaseContext(),DialogActivity.class));
	}
}

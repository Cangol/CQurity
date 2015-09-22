package com.azhuoinfo.cqurity.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.azhuoinfo.cqurity.AccountVerify;
import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.fragment.adapter.PeoplesAdapter;

import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

public class PeopleFragment extends BaseContentFragment {
	private AccountVerify mAccountVerify;
	private PeoplesAdapter adapter;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAccountVerify = AccountVerify.getInstance(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_tab_people, container, false);
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
		View v = view.findViewById(R.id.include_people);
		ListView listView = (ListView) v.findViewById(R.id.listView);
		adapter = new PeoplesAdapter(getActivity().getApplicationContext());
		listView.setAdapter(adapter);
	}
	
	@Override
	protected void initViews(Bundle savedInstanceState) {
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
}

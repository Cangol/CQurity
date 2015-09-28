package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azhuoinfo.cqurity.AccountVerify;
import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.view.ActionTabManager;

import mobi.cangol.mobile.actionbar.ActionMenu;
import mobi.cangol.mobile.actionbar.ActionMenuItem;
import mobi.cangol.mobile.actionbar.ActionTab;
import mobi.cangol.mobile.actionbar.ActionTabItem;
import mobi.cangol.mobile.actionbar.view.ActionTabView;
import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

public class DiscoveryFragment extends BaseContentFragment {
	private AccountVerify mAccountVerify;
    private ActionTabManager mActionTabManager;
    private ActionTab mActionTab;
    private int mCurrentId=1;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAccountVerify = AccountVerify.getInstance(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_discovery, container, false);
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
        mActionTabManager=new ActionTabManager(this.getActivity(),this.getChildFragmentManager(),R.id.layout_discovery);
        mActionTab=this.getCustomActionBar().createdActionTab();
	}
	
	@Override
	protected void initViews(Bundle savedInstanceState) {
		this.setTitle(R.string.title_discovery);
        mActionTabManager.addTab(mActionTab.newTab(1, getString(R.string.title_project), 1).getId(), ProjectFragment.class, "ProjectFragment", null);
        mActionTabManager.addTab(mActionTab.newTab(2, getString(R.string.title_people), 0).getId(), PeopleFragment.class, "PeopleFragment", null);
        mActionTab.setOnTabSelectedListener(new ActionTabView.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(ActionTabItem tab) {
                mCurrentId = tab.getId();
                mActionTabManager.setTabSelected("" + tab.getId());
                return true;
            }
        });
	}

	@Override
	protected void initData(Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            mCurrentId=savedInstanceState.getInt("currentId");
        }
        mActionTabManager.setTabSelected(""+mCurrentId);

	}
    @Override
    public void onDestroyView() {
        getCustomActionBar().clearActionTabs();
        super.onDestroyView();
    }
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
        outState.putInt("currentId",mCurrentId);
	}

	@Override
	protected FragmentInfo getNavigtionUpToFragment() {
		return null;
	}

	@Override
	protected boolean onMenuActionCreated(ActionMenu actionMenu) {
		actionMenu.add(new ActionMenuItem(3,null,R.drawable.actionbar_search,1));
		return super.onMenuActionCreated(actionMenu);
	}

	@Override
	protected boolean onMenuActionSelected(ActionMenuItem action) {
		switch (action.getId()){
			case 3:
				replaceFragment(SearchFragment.class,"SearchFragment",null);
				break;
		}
		return super.onMenuActionSelected(action);
	}

	@Override
	public boolean isCleanStack() {
		return true;
	}

}

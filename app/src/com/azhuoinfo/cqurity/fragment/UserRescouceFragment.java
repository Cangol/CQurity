package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.azhuoinfo.cqurity.AccountVerify;
import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.fragment.adapter.RescourceAdapter;
import com.azhuoinfo.cqurity.model.Rescouce;
import com.azhuoinfo.cqurity.view.AllGridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mobi.cangol.mobile.actionbar.ActionMenu;
import mobi.cangol.mobile.actionbar.ActionMenuItem;
import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

public class UserRescouceFragment extends BaseContentFragment {
	private AccountVerify mAccountVerify;
    private AllGridView mAllGridView;
    private RescourceAdapter mRescourceAdapter;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAccountVerify = AccountVerify.getInstance(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_user_resource, container, false);
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
        mAllGridView= (AllGridView) this.findViewById(R.id.gridview_user_resource);
	}
	
	@Override
	protected void initViews(Bundle savedInstanceState) {
		this.setTitle(R.string.title_activity);
        mRescourceAdapter=new RescourceAdapter(this.getActivity());
        mAllGridView.setAdapter(mRescourceAdapter);
        mAllGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
	}
    @Override
    protected boolean onMenuActionCreated(ActionMenu actionMenu) {
        actionMenu.add(new ActionMenuItem(1, R.string.action_menu_done, -1, 1));
        return true;
    }

    @Override
    protected boolean onMenuActionSelected(ActionMenuItem action) {
        switch (action.getId()) {
            case 1:
                this.replaceFragment(UserLocationFragment.class,"UserRescouceFragment",null);
                break;
        }
        return super.onMenuActionSelected(action);
    }
	@Override
	protected void initData(Bundle savedInstanceState) {
        String[] arrs=this.getResources().getStringArray(R.array.user_gender);
        List<Rescouce> list=new ArrayList<Rescouce>();
        for (int i=0;i<arrs.length;i++){
            list.add(new Rescouce(""+i,arrs[i]));
        }
        mRescourceAdapter.addAll(list);
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

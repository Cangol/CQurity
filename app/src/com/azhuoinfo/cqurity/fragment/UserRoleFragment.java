package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.azhuoinfo.cqurity.AccountVerify;
import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.fragment.adapter.RescourceAdapter;
import com.azhuoinfo.cqurity.model.Rescouce;
import com.azhuoinfo.cqurity.view.AllGridView;

import java.util.ArrayList;
import java.util.List;

import mobi.cangol.mobile.actionbar.ActionMenu;
import mobi.cangol.mobile.actionbar.ActionMenuItem;
import mobi.cangol.mobile.actionbar.view.SearchView;
import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

public class UserRoleFragment extends BaseContentFragment {
    private AccountVerify mAccountVerify;
    private AllGridView mAllGridView;
    private TextView mTitleTextView;
    private EditText mInputEditText;
    private RescourceAdapter mRescourceAdapter;
    private int selectIndex=0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAccountVerify = AccountVerify.getInstance(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_user_init, container, false);
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
        mTitleTextView= (TextView) this.findViewById(R.id.textview_userinit_title);
        mAllGridView= (AllGridView) this.findViewById(R.id.gridview_userinit_content);
        mInputEditText= (EditText) this.findViewById(R.id.edittext_userinit_input);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        this.setTitle(R.string.title_activity);
        mTitleTextView.setText(R.string.userinit_role_hint);
        mRescourceAdapter=new RescourceAdapter(this.getActivity());
        mRescourceAdapter.initLayoutParams(2+1);
        mAllGridView.setNumColumns(2);
        mAllGridView.setAdapter(mRescourceAdapter);
        mAllGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mInputEditText.setVisibility(View.VISIBLE);
                selectIndex=position;
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
                if(selectIndex==0){
                    this.replaceFragment(UserJobFragment.class,"UserJobFragment",null);
                }else{
                    this.replaceFragment(UserRescouceFragment.class,"UserRescouceFragment",null);
                }
                break;
        }
        return super.onMenuActionSelected(action);
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        String[] arrs=this.getResources().getStringArray(R.array.user_role);
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

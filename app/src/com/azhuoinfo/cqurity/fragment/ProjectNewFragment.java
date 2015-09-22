package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.azhuoinfo.cqurity.R;

import mobi.cangol.mobile.actionbar.ActionMenu;
import mobi.cangol.mobile.actionbar.ActionMenuItem;
import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

/**
 * Created by Administrator on 2015/9/21.
 */
public class ProjectNewFragment extends BaseContentFragment {
    private CheckBox mCheckBox;
    private ToggleButton mToggle;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_project_new, container, false);
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
        mCheckBox = (CheckBox) view.findViewById(R.id.checkbox_select);
        mToggle = (ToggleButton) view.findViewById(R.id.toggle_select);
    }

    @Override
    protected void initViews(Bundle bundle) {

        /**
         * ToggleButton的事件监听
         */
        mToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mCheckBox.setChecked(isChecked);
            }
        });
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected boolean onMenuActionCreated(ActionMenu actionMenu) {
        actionMenu.add(new ActionMenuItem(1,"Create",-1,1));
        return super.onMenuActionCreated(actionMenu);
    }

    @Override
    protected FragmentInfo getNavigtionUpToFragment() {
        return null;
    }
}

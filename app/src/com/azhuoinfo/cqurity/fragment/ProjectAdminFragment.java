package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.fragment.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;
import mobi.cangol.mobile.logging.Log;

/**
 * Created by Administrator on 2015/9/24.
 */
public class ProjectAdminFragment extends BaseContentFragment {
    private ListView mPost;
    private List<Map<String,String>> aList;
    private PostAdapter postAdapter;
    private TextView mAddPost;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_project_admin, container, false);

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
        mPost = (ListView) view.findViewById(R.id.listview_post);
        mAddPost = (TextView) view.findViewById(R.id.textview_post_add);
    }

    @Override
    protected void initViews(Bundle bundle) {
        aList = new ArrayList<Map<String, String>>();
        postAdapter = new PostAdapter(getActivity().getApplicationContext(),aList);
        mPost.setAdapter(postAdapter);

        mAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0;i<5;i++) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("position", "平面设计师");
                    map.put("state", "我们需要一位有独特想法的设计高手来和我们一起完成包装，Logo等设计项目");
                    aList.add(map);
                }
                postAdapter.notifyDataSetChanged();
                Log.d(aList.size()+"");
            }
        });

    }

    @Override
    protected void initData(Bundle bundle) {
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

package com.azhuoinfo.cqurity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.fragment.adapter.HistoryAdapter;
import com.azhuoinfo.cqurity.fragment.adapter.TeamGridAdapter;
import com.azhuoinfo.cqurity.fragment.adapter.PostAdapter;
import com.azhuoinfo.cqurity.view.ScrollListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobi.cangol.mobile.base.BaseContentFragment;
import mobi.cangol.mobile.base.FragmentInfo;

/**
 * Created by Administrator on 2015/9/24.
 */
public class ProjectAdminFragment extends BaseContentFragment {
    private ScrollListView mPost;
    private ListView mHistory;
    private PostAdapter postAdapter;
    private TextView mNum;
    private TextView mAddPost, mAddTeam;
    private GridView mTeam;
    private TeamGridAdapter teamGridAdapter;
    private LinearLayout mShowTeam;
    private List<Map<String, String>> aList;
    private int size = 0;

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
        mPost = (ScrollListView) view.findViewById(R.id.listview_post);
        mHistory = (ListView) view.findViewById(R.id.listview_history);
        mTeam = (GridView) view.findViewById(R.id.gridview_team_member);
        mAddPost = (TextView) view.findViewById(R.id.textview_post_add);
        mAddTeam = (TextView) view.findViewById(R.id.textview_team_member_add);
        mNum = (TextView) view.findViewById(R.id.textview_team_num);
        mShowTeam = (LinearLayout) view.findViewById(R.id.linearlayout_team_show);
    }

    @Override
    protected void initViews(Bundle bundle) {
        aList = new ArrayList<Map<String, String>>();
        postAdapter = new PostAdapter(getActivity().getApplicationContext(), aList);
        mPost.setAdapter(postAdapter);

        mAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("position", "平面设计师");
                map.put("state", "我们需要一位有独特想法的设计高手来和我们一起完成包装，Logo等设计项目");
                aList.add(map);
                postAdapter.notifyDataSetChanged();
            }
        });

        List<Map<String, String>> mList = new ArrayList<Map<String, String>>();
        for (int i = 0;i<5   ;i++){
            Map<String, String> map = new HashMap<String, String>();
            map.put("describe", "Chirs加入了团队，持股20%");
            map.put("time", "1 days ago");
            mList.add(map);
        }
        HistoryAdapter adapter = new HistoryAdapter(getActivity().getApplicationContext(),mList);
        mHistory.setAdapter(adapter);
        setListViewHeightBasedOnChildren(mHistory);


        if(size==0){
            mShowTeam.setVisibility(View.GONE);
        }

        teamGridAdapter = new TeamGridAdapter(getActivity().getApplicationContext(), size);
        mTeam.setAdapter(teamGridAdapter);
        mAddTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(mShowTeam.getVisibility()==View.VISIBLE)){
                    mShowTeam.setVisibility(View.VISIBLE);
                }
                size++;
                if (size > 4) {
                    if (!(mNum.getVisibility() == View.VISIBLE)) {
                        mNum.setVisibility(View.VISIBLE);
                    }
                    if ((size-4) > 99) {
                        mNum.setText("...");
                    } else {
                        mNum.setText("+" + (size - 4));
                    }
                }
                teamGridAdapter = new TeamGridAdapter(getActivity().getApplicationContext(), size);
                mTeam.setAdapter(teamGridAdapter);
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


    /*
     * 动态设置ListView组建的高度
	 */
    public void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {

            return;

        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) {

            View listItem = listAdapter.getView(i, null, listView);

            listItem.measure(0, 0);

            totalHeight += listItem.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight

                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        // listView.getDividerHeight()获取子项间分隔符占用的高度

        // params.height最后得到整个ListView完整显示需要的高度

        listView.setLayoutParams(params);

    }
}

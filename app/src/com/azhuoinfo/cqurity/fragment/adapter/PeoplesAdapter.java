package com.azhuoinfo.cqurity.fragment.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.view.imageview.round.RoundedImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2015/9/22.
 */
public class PeoplesAdapter extends BaseAdapter{
    private Context context;
    private List<Map<String,Object>> mList = new ArrayList<Map<String, Object>>();
    private boolean  isShowProject = true;

    public PeoplesAdapter(Context context){
        this.context = context;
    }

    public PeoplesAdapter(Context context , List<Map<String,Object>> mList){
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setShowProject(boolean b){
        isShowProject = b;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_people,null);
            holder.mRound = (RoundedImageView) convertView.findViewById(R.id.imageview_list_people_picture);
            holder.mName = (TextView) convertView.findViewById(R.id.textview_list_peopel_name);
            holder.mProject = (TextView) convertView.findViewById(R.id.textview_list_people_project);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        if(isShowProject){
            holder.mProject.setText("1 poject");
        }else{
            holder.mProject.setVisibility(View.GONE);
        }
        holder.mRound.setImageResource(R.drawable.ic_user_default);
        holder.mName.setText("James Ma");
        return convertView;
    }

    class ViewHolder{
        RoundedImageView mRound;
        TextView mName;
        TextView mProject;
    }
}

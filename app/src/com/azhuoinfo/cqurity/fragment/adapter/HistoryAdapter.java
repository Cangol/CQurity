package com.azhuoinfo.cqurity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.view.HistroyView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/25.
 */
public class HistoryAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String,String>> aList;

    public HistoryAdapter(Context context,List<Map<String,String>> aList){
        this.context = context;
        this.aList = aList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_project_admin_history,null);
            holder.mView = (HistroyView) convertView.findViewById(R.id.histroyview_project_admin);
            holder.mDescribe = (TextView) convertView.findViewById(R.id.textview_project_admin_hostroyview_describe);
            holder.mTime = (TextView) convertView.findViewById(R.id.textview_project_admin_hostroyview_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == aList.size()-1) {
            holder.mView.setShowRect(false);
        }
        holder.mDescribe.setText(aList.get(position).get("describe"));
        holder.mTime.setText(aList.get(position).get("time"));
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return aList.size();
    }

    class ViewHolder {
        HistroyView mView;
        TextView mDescribe,mTime;
    }
}

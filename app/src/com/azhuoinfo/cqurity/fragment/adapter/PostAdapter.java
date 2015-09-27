package com.azhuoinfo.cqurity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/24.
 */
public class PostAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String,String>> aList;

    public PostAdapter(Context context,List<Map<String,String>> aList){
        this.context = context;
        this.aList = aList;
    }

    @Override
    public int getCount() {
        return aList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_project_admin_post,null);
            holder.position = (TextView) convertView.findViewById(R.id.textview_list_post_position);
            holder.state = (TextView) convertView.findViewById(R.id.textview_list_post_state);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.position.setText(aList.get(position).get("position"));
        holder.state.setText(aList.get(position).get("state"));
        return convertView;
    }

    class ViewHolder{
        TextView position,state;
    }
}

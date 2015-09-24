package com.azhuoinfo.cqurity.fragment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;

/**
 * Created by Administrator on 2015/9/24.
 */
public class ProjectAdapter extends BaseAdapter {
    private Context context;


    public ProjectAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_project,null);
            holder.image = (ImageView) convertView.findViewById(R.id.imageview_list_project_image);
            holder.name = (TextView) convertView.findViewById(R.id.textview_list_project_name);
            holder.location = (TextView) convertView.findViewById(R.id.textview_list_project_location);
            holder.domain = (TextView) convertView.findViewById(R.id.textview_list_project_domian);
            holder.state = (TextView) convertView.findViewById(R.id.textview_list_project_state);
            holder.need = (TextView) convertView.findViewById(R.id.textview_list_project_need);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.image.setBackgroundResource(R.drawable.ic_user_default);
        holder.name.setText("CQurity");
        holder.location.setText("BeiJing");
        holder.domain.setText("Finance");
        holder.state.setText("国内首款移动珠宝营销专用工具");
        holder. need.setText("前端开发，社群经理");
        return convertView;
    }

    class ViewHolder{
        ImageView image;
        TextView name,location,domain,state,need;
    }
}

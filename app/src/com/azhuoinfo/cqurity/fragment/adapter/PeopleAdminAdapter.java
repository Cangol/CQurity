package com.azhuoinfo.cqurity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.view.RoundProgressBar;
import com.azhuoinfo.cqurity.view.imageview.round.RoundedImageView;

/**
 * Created by Administrator on 2015/9/25.
 */
public class PeopleAdminAdapter extends BaseAdapter {
    private Context context;

    public PeopleAdminAdapter(Context  context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 1;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_people_admin_projects,null);
            holder.text_prograss = (TextView) convertView.findViewById(R.id.textview_list_people_admin_state);
            holder.project = (TextView) convertView.findViewById(R.id.textview_list_people_admin_project);
            holder.task = (TextView) convertView.findViewById(R.id.textview_list_people_admin_task);
            holder.num = (TextView) convertView.findViewById(R.id.textview_list_people_admin_num);
            holder.progressBar = (RoundProgressBar) convertView.findViewById(R.id.roundprogressbar_list_people_admin_progress);
            holder.grid = (GridView) convertView.findViewById(R.id.gridview_list_people_admin_member);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text_prograss.setText("Ongoing");
        holder.project.setText("CQurity");
        holder.task.setText("Responsible for IT developing");
        holder.progressBar.setProgress(50);
        TeamGridAdapter adapter = new TeamGridAdapter(context,4);
        holder.grid.setAdapter(adapter);
        return convertView;
    }

    class ViewHolder{
        TextView text_prograss,project,task,num;
        RoundProgressBar progressBar;
        GridView grid;


    }
}

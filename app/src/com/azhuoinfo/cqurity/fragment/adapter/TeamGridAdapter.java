package com.azhuoinfo.cqurity.fragment.adapter;

/**
 * Created by Administrator on 2015/9/24.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.view.imageview.round.RoundedImageView;

public class TeamGridAdapter extends BaseAdapter {
    private int size = 0;
    private Context mContext;
    private LayoutInflater mInflater;
    private int selectIndex = -1;

    public TeamGridAdapter(Context context, int size) {
        this.mContext = context;
        this.size = size;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return size;
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

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.listview_item_project_admin_team_member,null);
            holder.imageView = (RoundedImageView) convertView.findViewById(R.id.imageview_list_item_team_portrait);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if(size>5){
        }
        holder.imageView.setImageResource(R.drawable.ic_user_default);
        return convertView;
    }

    private static class ViewHolder {
        RoundedImageView imageView;
    }

    public void setSelectIndex(int i) {
        selectIndex = i;
    }
}

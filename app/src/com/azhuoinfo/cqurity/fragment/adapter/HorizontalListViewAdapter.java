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

public class HorizontalListViewAdapter extends BaseAdapter {
    private int size = 0;
    private Context mContext;
    private LayoutInflater mInflater;
    private int selectIndex = -1;

    public HorizontalListViewAdapter(Context context, int size) {
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
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == selectIndex) {
            convertView.setSelected(true);
        } else {
            convertView.setSelected(false);
        }

        return convertView;
    }

    private static class ViewHolder {
    }

    public void setSelectIndex(int i) {
        selectIndex = i;
    }
}

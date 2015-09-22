package com.azhuoinfo.cqurity.fragment.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.azhuoinfo.cqurity.R;
import com.azhuoinfo.cqurity.model.Rescouce;
import com.azhuoinfo.cqurity.view.listview.BaseAdapter;


public class RescourceAdapter extends BaseAdapter<Rescouce> {
    private Context mContext;
    private int column=4;
    private AbsListView.LayoutParams mLayoutParams;
    private int[] color= {R.drawable.btn_circle_0_selector
            , R.drawable.btn_circle_1_selector
            , R.drawable.btn_circle_2_selector
            , R.drawable.btn_circle_3_selector
            , R.drawable.btn_circle_4_selector
            , R.drawable.btn_circle_5_selector
            , R.drawable.btn_circle_6_selector
    };
    public RescourceAdapter(Context context) {
        super(context);
        this.mContext = context;
        mLayoutParams= initLayoutParams(column);
    }

    public AbsListView.LayoutParams initLayoutParams(int size) {
        this.column=column;
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView. LayoutParams.MATCH_PARENT);
        layoutParams.width = (int) (displayMetrics.widthPixels-displayMetrics.density*8*(2+column-1))/size;
        layoutParams.height = layoutParams.width;
        return layoutParams;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Rescouce getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(),
                    R.layout.gridview_item_userinit, null);
            vh = new ViewHolder();
            vh.name = (TextView) convertView.findViewById(R.id.gridview_item_resource);
            convertView.setTag(vh);
            vh.name.setLayoutParams(mLayoutParams);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Rescouce item =getItem(position);
        vh.name.setText(item.getName());
        vh.name.setBackgroundResource(color[position%color.length]);
        return convertView;
    }



    class ViewHolder {
        TextView name;
    }
}

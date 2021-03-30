package com.testgridview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.testgridview.cn.R;

import java.util.List;

/**
 * Created by Administrator on 2021/3/29 0029.
 */

public class MyGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> img_list;
    private List<String> text_list;

    public MyGridAdapter(Context mContext,List<Integer> img_list,List<String> text_list){
        super();
        this.mContext = mContext;
        this.img_list = img_list;
        this.text_list = text_list;
    }

    @Override
    public int getCount() {
        return img_list.size();
    }

    @Override
    public Object getItem(int position) {
        return text_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item,parent,false);
        }
        TextView tv = BaseViewHolder.get(convertView,R.id.tv_item);
        ImageView iv = BaseViewHolder.get(convertView,R.id.iv_item);
        iv.setBackgroundResource(img_list.get(position));
        tv.setText(text_list.get(position));
        return convertView;
    }
}

package com.lapsen.intelligentboiler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lapsen.intelligentboiler.R;

/**
 * Created by wangchaohu on 2017/1/6.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private int[] icons;
    private String[] iconNames;

    public GridViewAdapter(Context mContext, int[] icons, String[] iconNames){

        this.mContext = mContext;
        /**
         * 初始化数据
         * */
        this.icons = icons;
        this.iconNames = iconNames;
    }

    @Override
    public int getCount() {
        return icons.length == iconNames.length ? icons.length : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_major_gridview, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.major_grid_Iv);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.major_grid_Tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(icons[position]);
        viewHolder.textView.setText(iconNames[position]);
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

    class ViewHolder{
        public ImageView imageView;
        public TextView textView;


    }

}

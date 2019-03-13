package com.android.intelligent.commonadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by wangchaohu on 2017/1/15.
 */

public abstract class CommonAdapter extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected int dataNum;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, int dataNum, int mItemLayoutId){
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.dataNum = dataNum;
        this.mItemLayoutId = mItemLayoutId;
    }

    @Override
    public int getCount() {
        return dataNum < 0 ? 0 : dataNum;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(convertView, parent);
        convert(viewHolder, position);
        return viewHolder.getmConvertView();
    }

    public abstract void convert(ViewHolder helper, int position);

    private ViewHolder getViewHolder(View convertView,
                                     ViewGroup parent)
    {
        return ViewHolder.getViewHolder(mContext, convertView, parent, mItemLayoutId);
    }
}

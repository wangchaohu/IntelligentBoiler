package com.android.intelligent.commonadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The type View holder.
 * 这个是通用的Adapter中的ViewHolder
 */
public class ViewHolder {
    private final SparseArray<View> mViews;
//    private int mPosition;
    private View mConvertView;


    public View getmConvertView() {
        return mConvertView;
    }

    /**
     * ViewHolder的构造器
     */
    private ViewHolder(Context context, ViewGroup parent, int layoutId) {
        this.mViews = new SparseArray<>();
            mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
            //setTag
            mConvertView.setTag(this);
//        this.mPosition = position;
    }

    /**
     * 拿到一个viewholder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @return
     */

    public static ViewHolder getViewHolder(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId);
        }
        return (ViewHolder) convertView.getTag();
    }

    /**
     * 通过控件的id获取控件，如果没有，则加入view
     *
     * @param viewId
     * @return
     */

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (null == view) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 设置Textview内容
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        if (null != view) {
            view.setText(text);
        }
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param imgId
     * @return
     */

    public ViewHolder setImg(int viewId, int imgId) {
        ImageView imgView = getView(viewId);
        if (null != imgView) {
            imgView.setImageResource(imgId);
        }
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap drawableId) {
        ImageView view = getView(viewId);
        if (null != view) {
            view.setImageBitmap(drawableId);
        }
        return this;
    }

    /**
     * 子列表的点击事件
     * */

    public ViewHolder setOnClickListener(int viewId, View.OnClickListener clickListener){
        View view = getView(viewId);
        if (null != view && null != clickListener){
            clickListener.onClick(view);
        }
        return this;
    }
}

package org.sinyi.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/22.
 */

public class ViewHolder {
    private SparseArray<View> mViews;
    private Context context;
    private int mPosition;
    private View mConverView;

    public  ViewHolder(int position, ViewGroup parent,int layOutId,Context context) {
        this.mPosition =position;
        this.context = context;
        mConverView = LayoutInflater.from(context).inflate(layOutId, parent, false);
        mViews = new SparseArray<>();
        mConverView.setTag(this);
    }

    public   static ViewHolder get(int position, View convertView, ViewGroup parent,Context context,int layOutId) {
        if (convertView == null) {

            return new ViewHolder(position, parent, layOutId,context);
        } else {
            ViewHolder  holder= (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /**
     * 通过viewId获取控件
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View>T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConverView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public View getmConverView() {
        return mConverView;
    }

    public ViewHolder setText(int viewId, String text) {
        TextView textview = getView(viewId);
        textview.setText( text);
        return  this;

    }
}

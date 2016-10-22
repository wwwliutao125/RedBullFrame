package org.sinyi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/10/22.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    public Context context;
    public List<T> mdata;
    private LayoutInflater layoutInflater;
    private  int itemLayoutId;
    public CommonAdapter(Context context, List<T> mdata, int itemLayoutId) {
        this.context = context;
        this.mdata = mdata;
        layoutInflater =layoutInflater.from(context);
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {

        return mdata.size();
    }

    @Override
    public T getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public  View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.get(position, convertView, parent, context, itemLayoutId);
        convert(viewHolder, getItem(position));
        return viewHolder.getmConverView();
    }

    public abstract void convert(ViewHolder viewHolder,T t);
}

package com.twospeak.twospeak;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
public class FeedbackAdpater extends BaseAdapter {
    private LayoutInflater mInflater;
    Context context;
    AlertDialog alertDialog;
    public FeedbackAdpater(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }
    @Override
    public int getCount() {
        return 2;
    }
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FeedbackAdpater.ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.tutor_list, null);
            holder = new FeedbackAdpater.ViewHolder();
            holder.start=(Button)convertView.findViewById(R.id.start);
            convertView.setTag(holder);
        } else {
            holder = (FeedbackAdpater.ViewHolder)convertView.getTag();
        }
        return convertView;
    }
    public static class ViewHolder {
        Button start;
    }
}
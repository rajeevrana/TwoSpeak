package com.twospeak.twospeak;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
public class TutorAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    Context context;
    AlertDialog alertDialog;
    public TutorAdapter(Context context) {
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }
	@Override
	public int getCount() {
        return 3;
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
    	 ViewHolder holder = null;
         if (convertView == null) {
             convertView = mInflater.inflate(R.layout.tutor_list, null);
             holder = new ViewHolder();
             holder.start=(Button)convertView.findViewById(R.id.start);
             holder.start.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view)
                 {
                     AlertDialog.Builder builder;
                     LayoutInflater inflater = (LayoutInflater) context
                             .getSystemService(context.LAYOUT_INFLATER_SERVICE);
                     View layout = inflater.inflate(R.layout.filter_list_layout_dialog,
                             null);
                    /* TextView dialog_header = (TextView) layout
                             .findViewById(R.id.dialog_header);*/
                     ListView list_item = (ListView) layout
                             .findViewById(R.id.list_item);
                     FeedbackAdpater feedbackAdapter = new FeedbackAdpater(context);
                     list_item.setAdapter(feedbackAdapter);
                     builder = new AlertDialog.Builder(context);
                     builder.setView(layout);
                     alertDialog = builder.create();
                     alertDialog.show();
                 }
             });

             convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        

		
		
        return convertView;
    }
    

public static class ViewHolder {
Button start;
}

}


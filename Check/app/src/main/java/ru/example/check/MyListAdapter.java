package ru.example.check;

import android.content.*;
import android.graphics.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import java.util.*;

//import android.support.v7.appcompat.R;

public class MyListAdapter extends ArrayAdapter<CheckItem> {


		private PageFragment page;
		private ArrayList<CheckItem> checkList;
    private LayoutInflater inflater;
    private int layout;


    public MyListAdapter(Context context, int textViewResourceId,
                         ArrayList<CheckItem> checkList,PageFragment page) {
        super(context, textViewResourceId, checkList);
        this.layout = textViewResourceId;
				this.page = page;
        this.inflater = LayoutInflater.from(context);
        this.checkList = checkList;
		}


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CheckItem checkItem = checkList.get(position);
        viewHolder.item.setText(checkItem.getOption());
        viewHolder.subitem.setText(checkItem.getValue());



        if (!page.isSpecialItem(position)) {
            viewHolder.subitem.setTextColor(0xff5e6060);
            viewHolder.imageView.setImageResource(R.mipmap.ic_message_text);
        } else {
            viewHolder.subitem.setTextColor(Color.GREEN);
            viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        }
        //   Log.d(TAG, "boolean position = " + myListAdapter.isSpecialItem(position));
        return convertView;
    }




    private class ViewHolder {

        final ImageView imageView;
        final TextView item, subitem;

        ViewHolder(View view) {
					  imageView = (ImageView) view.findViewById(R.id.imageView);
            item = (TextView) view.findViewById(R.id.itemView);
            subitem = (TextView) view.findViewById(R.id.subItemView);
        }
    }


}




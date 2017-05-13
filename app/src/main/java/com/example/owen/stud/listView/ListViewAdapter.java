package com.example.owen.stud.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.owen.stud.R;

import java.util.HashMap;

/**
 * Created by owen on 2017/5/12.
 */

public class ListViewAdapter extends ArrayAdapter {
    private Context context;
    private String[] beans;
    // 用于记录每个RadioButton的状态，并保证只可选一个
    HashMap<String, Boolean> states = new HashMap<String, Boolean>();

    class ViewHolder {

        TextView tvName;
        RadioButton rb_state;
    }

    public ListViewAdapter(Context context, String[] beans) {
        super(context,0);
        // TODO Auto-generated constructor stub
        this.beans = beans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return beans.length;
    }

    @Override
    public Object getItem(int position) {
        return beans[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

     @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // 页面
        ViewHolder holder;
        String bean = beans[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.items_list_view_main, null);
            holder = new ViewHolder();
//			holder.rb_state = (RadioButton) convertView
//					.findViewById(R.id.rb_light);
            holder.tvName = (TextView) convertView
                    .findViewById(R.id.tv_device_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(bean);
        final RadioButton radio=(RadioButton) convertView.findViewById(R.id.rb_light);
        holder.rb_state = radio;
        holder.rb_state.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // 重置，确保最多只有一项被选中
                for (String key : states.keySet()) {
                    states.put(key, false);
                }
                states.put(String.valueOf(position), radio.isChecked());
                ListViewAdapter.this.notifyDataSetChanged();
            }
        });

        boolean res = false;
        if (states.get(String.valueOf(position)) == null
                || states.get(String.valueOf(position)) == false) {
            res = false;
            states.put(String.valueOf(position), false);
        } else
            res = true;

        holder.rb_state.setChecked(res);
        return convertView;
    }
}

package com.example.owen.stud.recycleView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.owen.stud.R;

import java.util.ArrayList;

/**
 * Created by owen on 2017/5/12.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    ArrayList<NextActivity> mNextActivities = new ArrayList<NextActivity>();

    public MainAdapter(ArrayList<NextActivity> nextActivities) {
        this.mNextActivities = nextActivities;
    }

    @Override
    public MainHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.items_recycle_main, parent, false);
        final MainHolder viewHolder = new MainHolder(view);
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                NextActivity nextActivity = mNextActivities.get(position);
                parent.getContext().startActivity(new Intent(parent.getContext(), nextActivity.getActivityClass()));
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {
        NextActivity nextActivity = mNextActivities.get(position);
        holder.textView.setText(nextActivity.getActivityName());
    }

    @Override
    public int getItemCount() {
        return mNextActivities.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View mView;

        public MainHolder(View itemView) {
            super(itemView);
            this.mView = itemView;
            textView = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

    static class NextActivity {
        String activityName;
        Class<?> activityClass;

        public String getActivityName() {
            return activityName;
        }

        public Class<?> getActivityClass() {
            return activityClass;
        }

        public NextActivity(String activityName, Class<?> activityClass) {
            this.activityName = activityName;
            this.activityClass = activityClass;
        }


    }
}

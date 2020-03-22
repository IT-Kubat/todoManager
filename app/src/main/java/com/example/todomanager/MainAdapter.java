package com.example.todomanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    ArrayList<Task> data = new ArrayList<>();
    TaskClickListener listener;

    public void addTask(Task task){
        data.add(task);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.main_view_holder, parent, false);
        MainViewHolder vh =  new MainViewHolder(view);
        vh.listener = listener;
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.textView.setText((position +1)+ "" + data.get(position).title);
        holder.checkBox.setChecked(data.get(position).isDone);
        holder.task = data.get(position);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
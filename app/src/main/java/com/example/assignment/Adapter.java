package com.example.assignment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.databinding.ListItemBinding;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Event> mEvents;

    public Adapter(List<Event> mEvents) {
        this.mEvents = mEvents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list_item,parent,false);
        return new ViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.listItemBinding.setEvent(mEvents.get(i));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ListItemBinding listItemBinding;

        public ViewHolder(@NonNull ListItemBinding itemView) {
            super(itemView.getRoot());
            listItemBinding = itemView;
        }
    }
}

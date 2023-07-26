package com.example.myapplicationv2.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicationv2.data.repository.remote.ClickerListenerCallBack;
import com.example.myapplicationv2.databinding.ItemEmptyBinding;
import com.example.myapplicationv2.databinding.ItemListBinding;
import com.example.myapplicationv2.ui.adapter.holder.EmptyHolder;
import com.example.myapplicationv2.ui.adapter.holder.ListItemHolder;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ClickerListenerCallBack {

    public static final int TYPE_INCREASE = 1;
    public static final int TYPE_DECREASE = 2;

    List<News> items;

    public NewsAdapter() {}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TYPE_DECREASE:
                ItemListBinding itemBinding =
                        ItemListBinding.inflate(inflater, parent, false);
                return new ListItemHolder(itemBinding);

            default:
                ItemEmptyBinding emptyBinding =
                        ItemEmptyBinding.inflate(inflater, parent, false);
                return new EmptyHolder(emptyBinding);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ListItemHolder) {
            ((ListItemHolder) holder).bind((News) items.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items == null || items.size() == 0) {
            return 0;
        } else {
            return TYPE_DECREASE;
        }
    }

    @Override
    public int getItemCount() {
        if (items == null || items.size() == 0) {
            return 0;
        }
        return items.size();
    }

    public void removeItem(News item) {
        items.remove(item);
        notifyDataSetChanged();
    }

    public void addItems(List<News> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<News> items) {
        this.items = items;
        notifyDataSetChanged();
    }

}

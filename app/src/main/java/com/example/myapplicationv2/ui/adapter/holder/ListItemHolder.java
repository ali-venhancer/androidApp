package com.example.myapplicationv2.ui.adapter.holder;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicationv2.data.repository.remote.AdapterItemClickListener;
import com.example.myapplicationv2.databinding.ItemListBinding;
import com.example.myapplicationv2.ui.adapter.News;

public class ListItemHolder extends RecyclerView.ViewHolder{

    public ItemListBinding binding;

    private ImageView imageView;

    private AdapterItemClickListener listener;

    public ListItemHolder(ItemListBinding binding,AdapterItemClickListener adapterItemClickListener ) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = adapterItemClickListener;

        binding.myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemCLick(getAdapterPosition());
            }
        });
    }

    public void bind(News item) {
        binding.setItem(item);


        imageView = binding.imageViewCard;
        Glide.with(imageView)
                .load(item.image)
                .into(imageView);
    }
}

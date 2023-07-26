package com.example.myapplicationv2.ui.adapter.holder;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicationv2.databinding.ItemListBinding;
import com.example.myapplicationv2.ui.adapter.News;

public class ListItemHolder extends RecyclerView.ViewHolder{

    private ItemListBinding binding;

    private ImageView imageView;

    public ListItemHolder(ItemListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(News item) {
        binding.setItem(item);

        imageView = binding.imageViewCard;
        Glide.with(imageView)
                .load(item.image)
                .into(imageView);
    }
}

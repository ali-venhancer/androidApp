package com.example.myapplicationv2.ui.adapter.holder;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationv2.databinding.ItemEmptyBinding;


public class EmptyHolder extends RecyclerView.ViewHolder{

    private ItemEmptyBinding binding;

    public EmptyHolder(ItemEmptyBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /*public void bind(News item) {
        binding.setItem(item);
    }*/
}

package com.example.myapplicationv2.ui.itemdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.myapplicationv2.databinding.ItemDetailBinding;

public class ItemDetailFragment extends Fragment {

    private ItemDetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ItemDetailViewModel itemDetailViewModel =
                new ViewModelProvider(this).get(ItemDetailViewModel.class);

        binding = ItemDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Bundle bundle = getArguments();
        if (bundle != null) {

            String name = bundle.getString("name", "");
            String description = bundle.getString("description", "");
            String source = bundle.getString("source", "");
            String image = bundle.getString("image", "");

            binding.itemDetail.setText(name);
            binding.itemDescription.setText(description);
            binding.itemSource.setText(source);

            ImageView imageView = binding.imageViewCardDetail;

            Glide.with(imageView).load(image).into(imageView);
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

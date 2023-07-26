package com.example.myapplicationv2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplicationv2.data.repository.remote.DataResultCallBack;
import com.example.myapplicationv2.data.repository.remote.data.NewsResponse;
import com.example.myapplicationv2.databinding.FragmentHomeBinding;
import com.example.myapplicationv2.ui.adapter.NewsAdapter;

public class HomeFragment extends Fragment implements DataResultCallBack {

    private FragmentHomeBinding binding;
    HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initializeList();
        homeViewModel.getText().observe(getViewLifecycleOwner(), binding.textHome::setText);
        return root;
    }

    NewsAdapter adapter;

    private void initializeList() {
        adapter = new NewsAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(adapter);
        homeViewModel.getNews(this::result);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void result(NewsResponse response) {
        adapter.setItems(response.result);
    }

}
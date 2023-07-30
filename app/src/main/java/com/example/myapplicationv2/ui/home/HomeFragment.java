package com.example.myapplicationv2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplicationv2.R;
import com.example.myapplicationv2.data.repository.remote.AdapterItemClickListener;
import com.example.myapplicationv2.data.repository.remote.DataResultCallBack;
import com.example.myapplicationv2.data.repository.remote.data.NewsResponse;
import com.example.myapplicationv2.databinding.FragmentHomeBinding;
import com.example.myapplicationv2.databinding.ItemDetailBinding;
import com.example.myapplicationv2.ui.adapter.News;
import com.example.myapplicationv2.ui.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements DataResultCallBack, AdapterItemClickListener {

    private FragmentHomeBinding binding;
    HomeViewModel homeViewModel;

    public List<News> results = new ArrayList<>();

    private ItemDetailBinding detailBinding;

    NewsAdapter adapter;

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

    private void initializeList() {
        adapter = new NewsAdapter(this::onItemCLick);
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
        results = response.result;
        adapter.setItems(results);
    }

    @Override
    public void onItemCLick(int position) {
        News news = results.get(position);

        Bundle bundle = new Bundle();
        bundle.putString("name", news.name);
        bundle.putString("description", news.description);
        bundle.putString("source", news.source);
        bundle.putString("image", news.image);

        Navigation.findNavController(binding.getRoot()).navigate(R.id.itemDetailFragment, bundle);

    }
}
package com.example.lyton.activity_fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyton.R;
import com.example.lyton.adapter.PostAdapter;
import com.example.lyton.model.Post;
import com.example.lyton.viewModel.PostViewModel;

import java.util.ArrayList;
import java.util.List;


public class PostFragment extends Fragment {

    private PostAdapter postAdapter;

    private List<Post> posts = new ArrayList<>();


    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);


        //        RecyclerView setup
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_post);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        postAdapter = new PostAdapter(posts);
        recyclerView.setAdapter(postAdapter);

        //        View Model setup
        PostViewModel postViewModel = new ViewModelProvider(requireActivity()).get(PostViewModel.class);
        postViewModel.getAllPosts().observe(getViewLifecycleOwner(), posts -> postAdapter.updateData(posts));

        return view;
    }
}
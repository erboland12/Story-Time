package com.shapesandsuch.storytime.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shapesandsuch.storytime.R;
import com.shapesandsuch.storytime.backend.Poem;
import com.shapesandsuch.storytime.backend.Post;
import com.shapesandsuch.storytime.backend.Template;
import com.shapesandsuch.storytime.rv.PostsAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    //Recycler View variables
    public RecyclerView rvPosts;
    public static ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Post> tempPosts = new ArrayList<>();
    public static PostsAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //Initializes RV w/ adapter
        populateRecyclerView(posts);
        rvPosts = root.findViewById(R.id.rvPosts);
        adapter = new PostsAdapter(posts);

        rvPosts.setLayoutManager(new LinearLayoutManager(root.getContext()));
        rvPosts.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return root;
    }


    private void populateRecyclerView(ArrayList<Post> list){
        for(int i = 0; i < 10; i++){
            list.add(i, new Poem(Template.POEM, "BABADI BOOBADY", new ArrayList<String>(), 1231231));
        }
    }


}
package com.example.mhmdreza_j.mobile_p2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.mhmdreza_j.mobile_p2.network.PostProvider;
import com.example.mhmdreza_j.mobile_p2.network.PostService;
import com.example.mhmdreza_j.mobile_p2.network.PostsModel;
import com.example.mhmdreza_j.mobile_p2.network.Utility;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private boolean isGridView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gridView = findViewById(R.id.gridView);
        final LinearLayout listView = findViewById(R.id.listView);
        PostProvider provider = new PostProvider();
        PostService service = provider.getService();
        service.getPosts().enqueue(new Callback<PostsModel>() {
            @Override
            public void onResponse(Call<PostsModel> call, Response<PostsModel> response) {
                if (response.body() == null) return;
                ArrayList<Post> posts = response.body().getPosts();
                if (isGridView) {
                    GridAdapter adapter = new GridAdapter(getParent(), posts);
                    gridView.setAdapter(adapter);
                } else {
                    for (Post post:posts) {
                        View view = Utility.getListViewItem(getParent(), listView, post);
                        listView.addView(view);
                    }
                }
            }

            @Override
            public void onFailure(Call<PostsModel> call, Throwable t) {

            }
        });
    }
}
